package com.hhplus.hhplus3week.app.concertSchedule.dto;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ConcertScheduleRequestDTO {

    private Long id;
    private Long concertId;
    private Long concertScheduleId;
    private Long userId;
    private String token;
    private LocalDateTime selectedDate;
}
