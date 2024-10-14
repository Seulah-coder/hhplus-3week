package com.hhplus.hhplus3week.app.concertSchedule.dto;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ConcertScheduleDTO {

    private Long id;
    private Long concertId;
    private LocalDateTime openDate;
    private LocalDateTime ticketOpenDate;
}
