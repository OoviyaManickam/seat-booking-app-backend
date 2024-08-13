package com.seat.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seat.book.model.BookingEntity;
import com.seat.book.model.PaymentEntity;

public interface PaymentRepo extends JpaRepository<PaymentEntity, String>{
  PaymentEntity findByBooking(BookingEntity booking);
}
