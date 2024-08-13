package com.seat.book.model;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
@Table(name = "booking")
public class BookingEntity {
    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    private String bookingId;

    private String customerId;

    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
    private List<BookingSeatEntity> bookingSeats;

    private String bookingStatus;
    private String bookingTime;
}
