package com.seat.event.controller;

import com.seat.event.dto.EventDto;
import com.seat.event.model.EventEntity;
import com.seat.event.model.SeatEntity;
import com.seat.event.model.SlotEntity;
import com.seat.event.model.VenueEntity;
import com.seat.event.repository.EventRepo;
import com.seat.event.repository.SeatRepo;
import com.seat.event.repository.SlotRepo;
import com.seat.event.repository.VenueRepo;
import com.seat.event.service.EventService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/event")
public class EventController {
    @Autowired
    EventService service;

    @Autowired
    SlotRepo slotRepo;

    @Autowired
    EventRepo eventRepo;

    @Autowired
    VenueRepo venueRepo;

    @Autowired
    SeatRepo seatRepo;

    @PostMapping("/addevent")
    public ResponseEntity<EventDto> createEvent(@RequestBody EventDto data){
        return service.addEvents(data);
    }

    @GetMapping("/category")
    public List<EventEntity> getAllEvents(@RequestParam String category){
        return service.getEventsByCategory(category);
    }

    @GetMapping("/venue")
    public List<VenueEntity> getAllVenues(@RequestParam String eventid){
        return service.getVenue(eventid);
    }

    @PostMapping("/filter")
    public ResponseEntity<List<EventEntity>> getFilteredEvents(@RequestBody EventDto filter){
        return service.getFilteredEvents(filter);
    }

    @GetMapping("/seats")
    public List<SeatEntity> getAllSeats(@RequestParam String venueid){
        return service.getSeatArrangementforVenue(venueid);
    }

    @GetMapping("/slots")
    public ResponseEntity<List<SlotEntity>> getSlotsForEventAndVenue(@RequestParam String eventid, @RequestParam String venueid) {
        return service.getSlotsForEventAndVenue(eventid, venueid);
    }

    @GetMapping("/slots/{slotId}")
    public EventDto getSlot(@PathVariable String slotId) {
        SlotEntity slot = slotRepo.findById(slotId).orElseThrow(() -> new RuntimeException("Slot not found"));
        EventDto dto = new EventDto();
        EventEntity event = slot.getEvent();
        VenueEntity venue = slot.getVenue();
        BeanUtils.copyProperties(slot, dto);
        dto.setVenueId(venue.getVenueId());
        dto.setEventId(event.getEventId());
        System.out.println(dto.getEventId());
        return dto;
    }

    @GetMapping("/events/{eventId}")
    public EventDto getEvent(@PathVariable String eventId) {
        EventEntity event = eventRepo.findById(eventId).orElseThrow(() -> new RuntimeException("Event not found"));
        EventDto dto = new EventDto();
        BeanUtils.copyProperties(event, dto);
        return dto;
    }

    @GetMapping("/venues/{venueId}")
    public EventDto getVenue(@PathVariable String venueId) {
        VenueEntity venue = venueRepo.findById(venueId).orElseThrow(() -> new RuntimeException("Venue not found"));
        EventDto dto = new EventDto();
        BeanUtils.copyProperties(venue, dto);
        return dto;
    }

    @GetMapping("/seats/{seatId}")
    public ResponseEntity<String> getSeatNo(@PathVariable String seatId) {
        SeatEntity seat = seatRepo.findById(seatId).orElse(null);
        return ResponseEntity.ok(seat != null ? seat.getSeatNo() : null);
    }
}
