package com.hhplus.hhplus3week.app.seat.services;

import com.hhplus.hhplus3week.app.concertSchedule.models.ConcertSchedule;
import com.hhplus.hhplus3week.app.concertSchedule.services.ConcertScheduleService;
import com.hhplus.hhplus3week.app.seat.dto.SeatSaveDTO;
import com.hhplus.hhplus3week.app.seat.models.Seat;
import com.hhplus.hhplus3week.app.seat.models.SeatStatus;
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
    public void createInitSeat(SeatSaveDTO seatSaveDTO){
        ConcertSchedule concertSchedule = concertScheduleService.getConcertScheduleById(seatSaveDTO.getConcertScheduleId());
            for(int i=0; i<concertSchedule.getTotalSeatNumber(); i++){
                Seat seat = Seat.builder()
                        .seatNumber(seatSaveDTO.getSeatNumber() + i)
                        .price(seatSaveDTO.getPrice())
                        .concertSchedule(concertSchedule)
                        .seatStatus(SeatStatus.AVAILABLE)
                        .build();

                seatRepository.save(seat);
            }
    }

    @Transactional
    public Seat updateSeat(SeatSaveDTO seatSaveDTO){
        ConcertSchedule concertSchedule = concertScheduleService.getConcertScheduleById(seatSaveDTO.getConcertScheduleId());
        Seat seat = this.getSeatById(seatSaveDTO.getId());
        Seat newSeat = Seat.builder()
                .id(seat.getId())
                .seatNumber(seat.getSeatNumber())
                .price(seat.getPrice())
                .concertSchedule(concertSchedule)
                .seatStatus(seat.getSeatStatus())
                .build();
        return seatRepository.save(newSeat);
    }

    @Transactional
    public Seat updateSeatStatus(Long seatId, SeatStatus status){
        Seat seat = this.getSeatById(seatId);
        Seat newSeat = Seat.builder()
                .id(seat.getId())
                .seatStatus(status)
                .build();
        return seatRepository.save(newSeat);
    }

    public Seat getSeatByIdWithLock(Long seatId){
        return seatRepository.findByIdWithLock(seatId);
    }

    public Seat getSeatById(Long seatId){
        return seatRepository.findById(seatId).orElseThrow(() -> new RuntimeException("Seat with id " + seatId + " not found"));
    }


}
