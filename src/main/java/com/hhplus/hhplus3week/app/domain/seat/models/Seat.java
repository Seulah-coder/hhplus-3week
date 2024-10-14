package com.hhplus.hhplus3week.app.domain.seat.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "seat")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length=30)
    private Long id;

    @Column(length=30)
    private Long concertScheduleId;

    @Column(length=30)
    private Long seatNumber;

    @Column(length=30)
    private int price;

    @Column(length=30)
    private String seatStatus;

}
