package com.seat.event.dto;

import lombok.Data;

import java.sql.Date;
import java.sql.Time;

@Data
public class EventDto {
    private int status;
    private String eventId;
    private String categoryName;
    private String language;
    private String title;
    private String genre;
    private String imageUrl;
    private String description;
    private String venueId;
    private String venueName;
    private String location;
    private String slotId;
    private Date date;
    private Time time;
    private String seatId;
}
