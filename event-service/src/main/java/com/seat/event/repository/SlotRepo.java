package com.seat.event.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seat.event.model.EventEntity;
import com.seat.event.model.SlotEntity;
import com.seat.event.model.VenueEntity;

@Repository
public interface SlotRepo extends JpaRepository<SlotEntity, String> {
  List<SlotEntity> findByVenue(VenueEntity venue);

  List<SlotEntity> findByEventAndVenue(EventEntity event, VenueEntity venue);
}
