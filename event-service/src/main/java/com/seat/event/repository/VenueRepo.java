package com.seat.event.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.seat.event.model.EventEntity;
import com.seat.event.model.VenueEntity;

@Repository
public interface VenueRepo extends JpaRepository<VenueEntity, String> {
    VenueEntity findByVenueName(String venueName);

    VenueEntity findByVenueId(String venueId);

    List<VenueEntity> findByEvents(EventEntity event);

    @Query("SELECT v FROM VenueEntity v JOIN v.events e WHERE v.venueName = :venueName AND e.eventId = :eventId")
    List<VenueEntity> findByVenueNameAndEventId(@Param("venueName") String venueName, @Param("eventId") String eventId);
}
