package com.hhplus.hhplus3week.app.seat.models;

import com.hhplus.hhplus3week.app.concertSchedule.models.ConcertSchedule;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "seat")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length=30)
    private Long id;

    @Column(length=30)
    private Long seatNumber;

    @Column(length=30)
    private int price;

    @Column(length=30)
    private String seatStatus;

    @ManyToOne
    @JoinColumn(name = "concert_schedule_id")
    private ConcertSchedule concertSchedule;

}
