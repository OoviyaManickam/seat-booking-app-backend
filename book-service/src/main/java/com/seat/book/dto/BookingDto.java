package com.seat.book.dto;

import lombok.Data;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Data
public class BookingDto {
    private String bookingId;
    private double amount;
    private int status;
    private String message;
    private String imageUrl;
    private String title;
    private String language;
    private String venueName;
    private Date date;
    private Time time;
    private List<String> seatIds; 
    private List<String> seatNos; 
}
