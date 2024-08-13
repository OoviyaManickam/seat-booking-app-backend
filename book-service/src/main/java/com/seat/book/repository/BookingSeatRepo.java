package com.seat.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seat.book.model.BookingEntity;
import com.seat.book.model.BookingSeatEntity;
import java.util.List;


@Repository
public interface BookingSeatRepo extends JpaRepository<BookingSeatEntity, String> {
  boolean existsBySeatIdAndSlotId(String seatId, String slotId);

  BookingSeatEntity findBySeatIdAndSlotId(String seatId, String slotId);

  List<BookingSeatEntity> findByStatus(String status);

  List<BookingSeatEntity> findByBooking(BookingEntity booking);

}

