package com.seat.book.dto;

import lombok.Data;

@Data
public class EventResponse {
    private String eventId;
    private String title;
    private String language;
    private String imageUrl;
}
