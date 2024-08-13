package com.seat.event.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.seat.event.dto.EventDto;
import com.seat.event.dto.BookingSeatDto;
import com.seat.event.model.EventEntity;
import com.seat.event.model.SeatEntity;
import com.seat.event.model.SlotEntity;
import com.seat.event.model.VenueEntity;
import com.seat.event.repository.EventRepo;
import com.seat.event.repository.SeatRepo;
import com.seat.event.repository.SlotRepo;
import com.seat.event.repository.VenueRepo;

import jakarta.transaction.Transactional;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {
    @Autowired
    private EventRepo eventRepo;

    @Autowired
    private VenueRepo venueRepo;

    @Autowired
    private SlotRepo slotRepo;

    @Autowired
    private SeatRepo seatRepo;

    @Autowired
    private WebClient.Builder webClient;

    private static final List<String> SEAT_NUMBERS = Arrays.asList("A1", "A2", "A3","A4","A5", "B1", "B2", "B3","B4","B5","C1", "C2", "C3","C4","C5");

    private static final Logger logger = LoggerFactory.getLogger(EventService.class);

    public List<EventEntity> getEventsByCategory(String category){
        return eventRepo.findByCategoryName(category);
    }

    public List<VenueEntity> getVenue(String eventid){
        EventEntity event = eventRepo.findByEventId(eventid);
        return venueRepo.findByEvents(event);
    }

    public List<SeatEntity> getSeatArrangementforVenue(String venueid){
        return seatRepo.findByVenueId(venueid);
    }

    @Transactional
    public ResponseEntity<EventDto> addEvents(EventDto data) {
        EventEntity event = eventRepo.findByTitleAndCategoryName(data.getTitle(), data.getCategoryName());
        if (event == null) {
            event = new EventEntity();
            BeanUtils.copyProperties(data, event);
            eventRepo.save(event);
        }
    
        VenueEntity venue = venueRepo.findByVenueName(data.getVenueName());
        if (venue == null) {
            venue = new VenueEntity();
            BeanUtils.copyProperties(data, venue);
            venueRepo.save(venue);
    
            for (String seatno : SEAT_NUMBERS) {
                SeatEntity seat = new SeatEntity();
                seat.setSeatNo(seatno);
                seat.setVenue(venue);
                seat.setPrice(determinePriceforSeat(seatno));
                seatRepo.save(seat);
            }
        }
    
        // Ensure the venue's events list is initialized
        if (venue.getEvents() == null) {
            venue.setEvents(new ArrayList<>());
        }
    
        // Check if the event is already associated with the venue
        if (!venue.getEvents().contains(event)) { // Check for duplicates
            // Add event to the venue's events list and save the venue
            venue.getEvents().add(event);
            venueRepo.save(venue);
        }
    
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
    
        LocalDate slotDate = data.getDate().toLocalDate();
        LocalTime slotTime = data.getTime().toLocalTime();
    
        // Check if the slot date and time are in the future
        if (slotDate.isAfter(currentDate) || (slotDate.isEqual(currentDate) && slotTime.isAfter(currentTime))) {
            SlotEntity slot = new SlotEntity();
            BeanUtils.copyProperties(data, slot);
            slot.setVenue(venue);
            slot.setEvent(event); // Set the event reference in the slot
            slotRepo.save(slot);
    
            // Create a list of seat statuses for the newly created slot
            List<SeatEntity> seats = seatRepo.findByVenue(venue);
            BookingSeatDto seatStatus = new BookingSeatDto();
            List<String> seatIds = seats.stream()
                                         .map(SeatEntity::getSeatId)
                                         .collect(Collectors.toList());
    
            seatStatus.setSeatIds(seatIds);
            seatStatus.setSlotId(slot.getSlotId());
            seatStatus.setStatus("available");
    
            // Send the seat status to the booking service
            webClient.build().post()
                .uri("http://book-service/book/addbookingseats")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(List.of(seatStatus)), new ParameterizedTypeReference<List<BookingSeatDto>>() {})
                .retrieve()
                .bodyToMono(Void.class)
                .subscribe();
        } else {
            data.setStatus(500);
            return ResponseEntity.status(data.getStatus()).body(data);
        }
    
        data.setStatus(200);
        return ResponseEntity.status(data.getStatus()).body(data);
    }
    
    
    
    

    public double determinePriceforSeat(String seatno){
        double price;
        if(seatno.startsWith("A")){
            price = 100.00;
        }else{
            price = 200.00;
        }
        return price;
    }

    public ResponseEntity<List<SlotEntity>> getSlotsForEventAndVenue(String eventId, String venueId) {
        EventEntity event = eventRepo.findByEventId(eventId);
        VenueEntity venue = venueRepo.findByVenueId(venueId);
        List<SlotEntity> slots = slotRepo.findByEventAndVenue(event, venue);
        if (slots.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
        }
        return ResponseEntity.ok(slots);
    }

    public ResponseEntity<List<EventEntity>> getFilteredEvents(EventDto filter) {
        List<EventEntity> events =  eventRepo.findFilteredEvents(
            filter.getTitle(),
            filter.getLanguage(),
            filter.getVenueName(),
            filter.getLocation(),
            filter.getDate(),
            filter.getCategoryName()
        );
        return ResponseEntity.ok(events);
    }

    @Scheduled(cron = "0 0 * * * ?")
    public void deleteOutdatedSlots() {
        LocalDateTime now = LocalDateTime.now();

        logger.info("Running task to delete all outdated events ", now);

        List<SlotEntity> outdatedSlots = slotRepo.findAll().stream()
            .filter(slot -> LocalDateTime.of(slot.getDate().toLocalDate(), slot.getTime().toLocalTime())
                                          .isBefore(now))
            .collect(Collectors.toList());
        slotRepo.deleteAll(outdatedSlots);
    }
    
}
