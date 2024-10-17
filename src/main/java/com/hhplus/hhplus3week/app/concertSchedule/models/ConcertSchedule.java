package com.hhplus.hhplus3week.app.concertSchedule.models;

import com.hhplus.hhplus3week.app.concert.models.Concert;
import com.hhplus.hhplus3week.app.seat.models.Seat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "concert_schedule")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ConcertSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length=100)
    private String concertPlace;
    @Column(length=100)
    private LocalDateTime openDatetime;
    @Column(length=100)
    private LocalDateTime ticketOpenDate;

    @ManyToOne
    @JoinColumn(name = "concert_id")
    private Concert concert;

    @OneToMany(mappedBy = "concertSchedule", fetch = FetchType.LAZY)
    private List<Seat> seatList;
}
