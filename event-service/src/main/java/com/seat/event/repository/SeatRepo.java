package com.seat.event.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.seat.event.model.SeatEntity;
import com.seat.event.model.VenueEntity;

@Repository
public interface SeatRepo extends JpaRepository<SeatEntity, String> {

    @Query("SELECT s FROM SeatEntity s WHERE s.venue.venueId = :venueId order by s.seatNo")
    List<SeatEntity> findByVenueId(@Param("venueId") String venueId);

    List<SeatEntity> findByVenue(VenueEntity venue);

}
