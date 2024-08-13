package com.seat.book.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import com.seat.book.dto.BookingDto;
import com.seat.book.dto.BookingSeatDto;
import com.seat.book.dto.EventResponse;
import com.seat.book.dto.SlotResponse;
import com.seat.book.dto.VenueResponse;
import com.seat.book.model.BookingEntity;
import com.seat.book.model.BookingSeatEntity;
import com.seat.book.model.PaymentEntity;
import com.seat.book.repository.BookingRepo;
import com.seat.book.repository.BookingSeatRepo;
import com.seat.book.repository.PaymentRepo;

@Service
public class BookingService {
    @Autowired
    BookingSeatRepo bookingSeatRepo;

    @Autowired
    private BookingRepo bookingRepo;

    @Autowired
    private WebClient.Builder webClient;

    @Autowired
    private PaymentRepo paymentRepo;

    private static final Logger logger = LoggerFactory.getLogger(BookingService.class);

    public void addSeatStatusforEvents(List<BookingSeatDto> seatStatuses) {
        for (BookingSeatDto data : seatStatuses) {
            for (String seatId : data.getSeatIds()) {
                boolean exists = bookingSeatRepo.existsBySeatIdAndSlotId(seatId, data.getSlotId());
                if (!exists) {
                    BookingSeatEntity bookSeatEntry = new BookingSeatEntity();
                    bookSeatEntry.setSeatId(seatId);
                    bookSeatEntry.setSlotId(data.getSlotId());
                    bookSeatEntry.setStatus(data.getStatus());
                    bookingSeatRepo.save(bookSeatEntry);
                }
            }
        }
    }


    public Map<String, String> getStatusforSeats(BookingSeatDto data) {
        List<String> seatIds = data.getSeatIds();
        String slotId = data.getSlotId();
        Map<String, String> seatStatuses = new HashMap<>();
        
        for (String seatId : seatIds) {
            BookingSeatEntity bookingSeat = bookingSeatRepo.findBySeatIdAndSlotId(seatId, slotId);
            if (bookingSeat != null) {
                seatStatuses.put(seatId, bookingSeat.getStatus());
            } else {
                seatStatuses.put(seatId, "Seat not found");
            }
        }
        return seatStatuses;
    }

    @Transactional
    public BookingDto bookSeats(BookingSeatDto bookingSeatDto, String token) {
        List<String> seatIds = bookingSeatDto.getSeatIds();
        String slotId = bookingSeatDto.getSlotId();
        List<BookingSeatEntity> bookingSeats = new ArrayList<>();

        for (String seatId : seatIds) {
            BookingSeatEntity bookingSeat = bookingSeatRepo.findBySeatIdAndSlotId(seatId, slotId);

            if (!"available".equals(bookingSeat.getStatus())) {
                throw new RuntimeException("Seat " + seatId + " is not available for booking");
            }

            bookingSeat.setStatus("locked");
            bookingSeat.setLockedAt(LocalDateTime.now());
            bookingSeatRepo.save(bookingSeat);

            bookingSeats.add(bookingSeat);
        }

        BookingEntity booking = new BookingEntity();
        String customerId = webClient.build().get()
                .uri("http://auth-service/auth/token")
                .header("Authorization", "Bearer " + token)
                .retrieve()
                .bodyToMono(String.class)
                .block();
        booking.setCustomerId(customerId);
        booking.setBookingSeats(bookingSeats);
        booking.setBookingStatus("pending");
        booking.setBookingTime(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));

        for (BookingSeatEntity seat : bookingSeats) {
            seat.setBooking(booking);
        }
        bookingRepo.save(booking);

        BookingDto response = new BookingDto();
        response.setBookingId(booking.getBookingId());
        response.setSeatIds(seatIds);
        response.setStatus(200);
        response.setMessage("Seats locked");
        return response;
    }



    @Transactional
    public PaymentEntity processPayment(String bookingId, double amount) {
        BookingEntity booking = bookingRepo.findByBookingId(bookingId);
        if (!"pending".equals(booking.getBookingStatus())) {
            throw new RuntimeException("Booking is not in a pending state");
        }
        boolean paymentSuccess = true;

        PaymentEntity payment = new PaymentEntity();
        payment.setBooking(booking);
        payment.setAmount(amount);
        payment.setPaymentTime(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));

        if (paymentSuccess) {
            payment.setPaymentStatus("success");
            booking.setBookingStatus("confirmed");
            for (BookingSeatEntity bookingSeat : booking.getBookingSeats()) {
                bookingSeat.setStatus("booked");
                bookingSeatRepo.save(bookingSeat);
            }
        } else {
            payment.setPaymentStatus("failed");
            booking.setBookingStatus("cancelled");
            for (BookingSeatEntity bookingSeat : booking.getBookingSeats()) {
                bookingSeat.setStatus("available");
                bookingSeat.setBooking(null);
                bookingSeat.setLockedAt(null);
                bookingSeatRepo.save(bookingSeat);
            }
        }
        bookingRepo.save(booking);
        return paymentRepo.save(payment);
    }



    @Scheduled(fixedRate = 60000)
    public void releaseExpiredLocks() {
        LocalDateTime now = LocalDateTime.now();
        List<BookingSeatEntity> lockedSeats = bookingSeatRepo.findByStatus("locked");

        logger.info("Running task to cancel expired bookings", now);

        for (BookingSeatEntity seatStatus : lockedSeats) {
            if (seatStatus.getLockedAt() != null) {
                long minutesLocked = ChronoUnit.MINUTES.between(seatStatus.getLockedAt(), now);
                logger.info("Seat {} locked for {} minutes", seatStatus.getSeatId(), minutesLocked);

                if (minutesLocked >= 2) {
                logger.info("Releasing lock for seat {}", seatStatus.getSeatId());
                List<BookingEntity> bookings = bookingRepo.findByBookingSeats_SeatIdAndBookingStatus(seatStatus.getSeatId(), "pending");
                for (BookingEntity booking : bookings) {
                    booking.setBookingStatus("cancelled");
                    bookingRepo.save(booking);
                }
                seatStatus.setStatus("available");
                seatStatus.setLockedAt(null);
                seatStatus.setBooking(null);
                bookingSeatRepo.save(seatStatus);
                }
            }
        }
    }

    public List<BookingSeatEntity> getSeatEntities(String bookingid){
        BookingEntity booking = bookingRepo.findByBookingId(bookingid);
        List<BookingSeatEntity> seats = bookingSeatRepo.findByBooking(booking);
        return seats;
    }

    public ResponseEntity<List<BookingDto>> getUserBookings(String token) {
        String customerId = webClient.build().get()
                .uri("http://auth-service/auth/token")
                .header("Authorization", "Bearer " + token)
                .retrieve()
                .bodyToMono(String.class)
                .block();
        List<BookingEntity> bookings = bookingRepo.findByCustomerId(customerId);

        List<BookingDto> bookingDtos = bookings.stream()
            .filter(booking -> "confirmed".equals(booking.getBookingStatus()))
            .map(booking -> {
                BookingDto dto = new BookingDto();
                dto.setBookingId(booking.getBookingId());

            PaymentEntity payment = paymentRepo.findByBooking(booking);
            if (payment != null) {
                dto.setAmount(payment.getAmount());
            }

            List<String> seatIds = booking.getBookingSeats().stream()
                    .map(BookingSeatEntity::getSeatId)
                    .collect(Collectors.toList());
            dto.setSeatIds(seatIds);

            List<String> seatNos = seatIds.stream()
            .map(seatId -> {
                return webClient.build().get()
                        .uri("http://event-service/event/seats/" + seatId) 
                        .retrieve()
                        .bodyToMono(String.class)
                        .block();
            })
            .collect(Collectors.toList());
            dto.setSeatNos(seatNos);

            if (!booking.getBookingSeats().isEmpty()) {
                BookingSeatEntity firstSeat = booking.getBookingSeats().get(0);
                String slotId = firstSeat.getSlotId();

                SlotResponse slotResponse = webClient.build().get()
                        .uri("http://event-service/event/slots/" + slotId)
                        .retrieve()
                        .bodyToMono(SlotResponse.class)
                        .block();
                dto.setDate(slotResponse.getDate());
                dto.setTime(slotResponse.getTime());

                EventResponse eventResponse = webClient.build().get()
                        .uri("http://event-service/event/events/" + slotResponse.getEventId())
                        .retrieve()
                        .bodyToMono(EventResponse.class)
                        .block();
                dto.setTitle(eventResponse.getTitle());
                dto.setLanguage(eventResponse.getLanguage());
                dto.setImageUrl(eventResponse.getImageUrl());

                
                VenueResponse venueResponse = webClient.build().get()
                        .uri("http://event-service/event/venues/" + slotResponse.getVenueId())
                        .retrieve()
                        .bodyToMono(VenueResponse.class)
                        .block();
                dto.setVenueName(venueResponse.getVenueName());
            }

            return dto;
        }).collect(Collectors.toList());

        return ResponseEntity.ok(bookingDtos);
    }
}
