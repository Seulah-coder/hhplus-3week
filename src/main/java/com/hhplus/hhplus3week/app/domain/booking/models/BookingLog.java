package com.hhplus.hhplus3week.app.domain.booking.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "booking_log")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookingLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length=30)
    private Long userId;

    @Column(length=30)
    private Long seatId;

    @Column(length=100)
    private LocalDateTime bookingTime;

    @Column(length=30)
    private String bookingStatus;

    @Column(length=100)
    private String concertName;

    @Column(length=100)
    private LocalDateTime concertDate;

    @Column(length=30)
    private int price;

    @Column(length=30)
    private Long seatNumber;
}