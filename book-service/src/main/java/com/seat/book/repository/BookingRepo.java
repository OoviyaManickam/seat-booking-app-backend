package com.seat.book.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.seat.book.model.BookingEntity;

public interface BookingRepo extends JpaRepository<BookingEntity, String>{
  BookingEntity findByBookingId(String bookingId);

  List<BookingEntity> findByBookingSeats_SeatIdAndBookingStatus(String seatId, String bookingStatus);

  List<BookingEntity> findByCustomerId(String customerId);
}
