package com.hhplus.hhplus3week.app.concertSchedule.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ConcertScheduleSaveDTO {

    private Long id;
    private Long concertId;
    private String concertPlace;
    private LocalDateTime concertOpenDate;
    private LocalDateTime ticketOpenDate;
    private int totalSeatNumber;
    private int currentBookedSeatNumber;

}
