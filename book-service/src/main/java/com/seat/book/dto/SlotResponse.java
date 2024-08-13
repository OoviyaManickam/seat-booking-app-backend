package com.seat.book.dto;

import java.sql.Time;

import lombok.Data;

import java.sql.Date;

@Data
public class SlotResponse {
    private String slotId;
    private Date date;
    private Time time;
    private String eventId;
    private String venueId;
}
