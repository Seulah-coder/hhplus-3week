package com.hhplus.hhplus3week.app.domain.booking.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_booking_log")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookingLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
