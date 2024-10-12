package com.hhplus.hhplus3week.domain.booking.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_booking")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
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
