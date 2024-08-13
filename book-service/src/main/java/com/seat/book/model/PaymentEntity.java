package com.seat.book.model;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "payment")
public class PaymentEntity {
    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    private String paymentId;

    @ManyToOne
    @JoinColumn(name = "booking_id", nullable = false)
    private BookingEntity booking;

    private double amount;
    private String paymentStatus;
    private String paymentTime;
}
