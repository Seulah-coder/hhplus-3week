package com.hhplus.hhplus3week.app.api.seat.dto;

import lombok.Data;

@Data
public class SeatDTO {

    private Long id;
    private Long concertScheduleId;
    private Long seatNumber;
    private int price;
    private String seatStatus;
    private Long tempUserId;
    private Long tempExpireTime;
}
