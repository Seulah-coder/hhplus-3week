package com.hhplus.hhplus3week.api.booking.dto;

import java.time.LocalDateTime;

public class BookingDTO {

    private Long id;
    private Long userId;
    private Long seatId;
    private LocalDateTime bookingTime;
    private String bookingStatus;
    private String concertName;
    private LocalDateTime concertDate;
    private int price;
    private Long seatNumber;
}
