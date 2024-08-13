package com.seat.event.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany; // Import this for the slots relationship
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;

@Entity
@Data
@Table(name = "event")
public class EventEntity {
    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    private String eventId;
    private String categoryName;
    private String language;
    private String title;
    private String genre;
    private String imageUrl;
    private String description;

    @ManyToMany(mappedBy = "events")
    @JsonManagedReference
    private List<VenueEntity> venues;

    @OneToMany(mappedBy = "event") // This establishes the one-to-many relationship with SlotEntity
    @JsonManagedReference
    private List<SlotEntity> slots; // Add this line to reference the slots
}
