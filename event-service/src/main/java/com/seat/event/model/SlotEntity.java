package com.seat.event.model;

import org.hibernate.annotations.UuidGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.sql.Date;
import java.sql.Time;

@Entity
@Data
@Table(name = "slot")
public class SlotEntity {
    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    private String slotId;
    
    private Date date;
    private Time time;

    @ManyToOne
    @JoinColumn(name = "venue_id", nullable = false)
    @JsonBackReference
    private VenueEntity venue;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    @JsonBackReference
    private EventEntity event; 
}

