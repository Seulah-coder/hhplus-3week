package com.hhplus.hhplus3week.app.seat.dto;

import lombok.Data;

@Data
public class SeatSaveDTO {

    private Long id;
    private Long concertScheduleId;
    private Long seatNumber;
    private int price;
    private String seatStatus;
}
