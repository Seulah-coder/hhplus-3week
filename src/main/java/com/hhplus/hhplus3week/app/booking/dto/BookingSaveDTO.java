package com.hhplus.hhplus3week.app.booking.dto;


import com.hhplus.hhplus3week.app.booking.models.BookingStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BookingSaveDTO {

    private Long id;
    private Long userId;
    private Long seatId;
    private LocalDateTime bookingTime;
    private BookingStatus bookingStatus;
    private String concertName;
    private LocalDateTime concertDate;
    private int price;
    private Long seatNumber;
    private Long paymentId;
    private Long concertScheduleId;
    private Long tempUserId;
    private LocalDateTime tempExpiredTime;
}
