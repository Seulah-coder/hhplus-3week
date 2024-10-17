package com.hhplus.hhplus3week.app.seat.services;

import com.hhplus.hhplus3week.app.concert.services.ConcertService;
import com.hhplus.hhplus3week.app.concertSchedule.models.ConcertSchedule;
import com.hhplus.hhplus3week.app.concertSchedule.services.ConcertScheduleService;
import com.hhplus.hhplus3week.app.seat.dto.SeatDTO;
import com.hhplus.hhplus3week.app.seat.models.Seat;
import com.hhplus.hhplus3week.app.seat.repositories.SeatRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SeatService {

    private final SeatRepository seatRepository;
    //TODO: 서비스 참조가 맞는걸까?
    private final ConcertScheduleService concertScheduleService;

    @Transactional
    public Seat saveSeat(SeatDTO seatDTO){
        ConcertSchedule concertSchedule = concertScheduleService.getConcertScheduleById(seatDTO.getConcertScheduleId());

        Seat seat = Seat.builder()
                .seatNumber(seatDTO.getSeatNumber())
                .price(seatDTO.getPrice())
                .concertSchedule(concertSchedule)
                .seatStatus(seatDTO.getSeatStatus())
                .build();

        return seatRepository.save(seat);
    }

    public Seat getSeatbyIdWithLock(Long seatId){
        return seatRepository.findByIdWithLock(seatId);
    }


}
