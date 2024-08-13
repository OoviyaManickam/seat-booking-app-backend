package com.seat.event.dto;

import lombok.Data;
import java.util.List;

@Data
public class BookingSeatDto {
    private List<String> seatIds;
    private String slotId;
    private String status;
}
