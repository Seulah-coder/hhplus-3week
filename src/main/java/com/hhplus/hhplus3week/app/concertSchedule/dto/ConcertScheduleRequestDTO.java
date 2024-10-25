package com.hhplus.hhplus3week.app.concertSchedule.dto;


import lombok.Data;

@Data
public class ConcertScheduleRequestDTO {

    private Long id;
    private Long concertId;
    private Long userId;
    private String token;

}
