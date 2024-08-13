package com.seat.book.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.seat.book.dto.BookingDto;
import com.seat.book.dto.BookingSeatDto;
import com.seat.book.model.BookingSeatEntity;
import com.seat.book.service.BookingService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/book")
public class BookingController {
  @Autowired
  BookingService service;

  @PostMapping("/addbookingseats")
  public void handleBookingSeats(@RequestBody List<BookingSeatDto> data){
    service.addSeatStatusforEvents(data);
  }

  @PostMapping("/getstatus")
  public Map<String, String> handleSeatStatus(@RequestBody BookingSeatDto data){
    return service.getStatusforSeats(data);
  }

  @PostMapping("/bookseat")
    public BookingDto bookSeat(@RequestBody BookingSeatDto data, @RequestHeader("Authorization") String token) {
      return service.bookSeats(data, token);
  }

  @PostMapping("/payment")
    public ResponseEntity<String> processPayment(@RequestBody BookingDto data) {
        service.processPayment(data.getBookingId(), data.getAmount());
        return ResponseEntity.ok("success");
    }

    @GetMapping("/seatsbooking")
    public List<BookingSeatEntity> getSeats(@RequestParam String bookingid){
      return service.getSeatEntities(bookingid);
    }

    @GetMapping("/user/bookings")
    public ResponseEntity<List<BookingDto>> getUserBookings(@RequestHeader("Authorization") String token) {
        return service.getUserBookings(token);
    }
}
