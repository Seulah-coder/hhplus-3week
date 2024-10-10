package com.hhplus.hhplus3week.domain.booking.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "TB_BOOKING_HISTORY")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookingLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "SEAT_ID")
    private Long seatId;

    @Column(name = "BOOKING_TIME")
    private LocalDateTime bookingTime;

    @Column(name = "BOOKING_STATUS")
    private String bookingStatus;

    @Column(name = "CONCERT_NAME")
    private String concertName;

    @Column(name = "CONCERT_DATE")
    private LocalDateTime concertDate;

    @Column(name = "PRICE")
    private int price;

    @Column(name = "SEAT_NUMBER")
    private Long seatNumber;
}
