package com.seat.event.model;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;

@Entity
@Data
@Table(name = "venue")
public class VenueEntity {
    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    private String venueId;
    private String venueName;
    private String location;

    @ManyToMany
    @JoinTable(
        name = "event_venue",
        joinColumns = @JoinColumn(name = "venue_id"),
        inverseJoinColumns = @JoinColumn(name = "event_id")
    )
    @JsonBackReference
    private List<EventEntity> events;

    @OneToMany(mappedBy = "venue")
    @JsonManagedReference
    private List<SlotEntity> slots;

    @OneToMany(mappedBy = "venue")
    @JsonBackReference
    private List<SeatEntity> seats;
}
