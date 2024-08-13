package com.seat.event.model;

import org.hibernate.annotations.UuidGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "seat")
public class SeatEntity {
  @Id
  @UuidGenerator(style = UuidGenerator.Style.RANDOM)
  private String seatId;
  private String seatNo;
  private double price;

  @ManyToOne
  @JoinColumn(name = "venue_id")
  @JsonBackReference
  private VenueEntity venue;
}
