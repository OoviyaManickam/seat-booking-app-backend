package com.seat.book.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "book_seat")
public class BookingSeatEntity {
    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    private String bookingSeatId;

    private String seatId;
    private String slotId;
    private String status; // e.g., available, locked, booked
    private LocalDateTime lockedAt;

    @ManyToOne
    @JoinColumn(name = "booking_id", nullable = true)
    private BookingEntity booking;
}
