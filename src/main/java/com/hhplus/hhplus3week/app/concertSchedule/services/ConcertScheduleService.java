package com.hhplus.hhplus3week.app.concertSchedule.services;

import com.hhplus.hhplus3week.app.common.JwtProvider;
import com.hhplus.hhplus3week.app.concert.services.ConcertService;
import com.hhplus.hhplus3week.app.concertSchedule.dto.ConcertScheduleRequestDTO;
import com.hhplus.hhplus3week.app.concertSchedule.dto.ConcertScheduleSaveDTO;
import com.hhplus.hhplus3week.app.concertSchedule.models.ConcertSchedule;
import com.hhplus.hhplus3week.app.concertSchedule.repositories.ConcertScheduleRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ConcertScheduleService {

    private final ConcertScheduleRepository concertScheduleRepository;
    // TODO: 서비스를 주입하는게 맞나?
    private final ConcertService concertService;
    private final JwtProvider jwtProvider;

    @Transactional
    public ConcertSchedule saveConcertSchedule(ConcertScheduleSaveDTO concertScheduleSaveDTO) {

        ConcertSchedule concertSchedule = ConcertSchedule.builder()
                .concertPlace(concertScheduleSaveDTO.getConcertPlace())
                .concertOpenDate(concertScheduleSaveDTO.getConcertOpenDate())
                .concert(concertService.getConcertById(concertScheduleSaveDTO.getConcertId()))
                .currentBookedSeatNumber(concertScheduleSaveDTO.getCurrentBookedSeatNumber())
                .totalSeatNumber(concertScheduleSaveDTO.getTotalSeatNumber())
                .build();
        return concertScheduleRepository.save(concertSchedule);
    }
    public ConcertSchedule getConcertScheduleById(Long id) {
        return concertScheduleRepository.findById(id).orElse(null);
    }

    /**
     * 선택한 콘서트와 좌석 조회
     * @param concertScheduleRequestDTO
     * @return
     */
    public ConcertSchedule getConcertScheduleByIdWithAvailableSeats(ConcertScheduleRequestDTO concertScheduleRequestDTO) {
        boolean checkTokenValidation = jwtProvider.validateToken(concertScheduleRequestDTO.getToken() , concertScheduleRequestDTO.getUserId());
        if(checkTokenValidation){
            return concertScheduleRepository.findByIdWithSeats(concertScheduleRequestDTO.getConcertScheduleId());
        } else {
            //TODO: 글로벌로 exception 처리 만들기
            throw new RuntimeException("Invalid token");
        }
    }

    /**
     * 콘서트 스케줄 리스트 조회
     * @param concertScheduleRequestDTO
     * @return
     */
    public List<ConcertSchedule> getConcertScheduleByConcertIdAfterDate(ConcertScheduleRequestDTO concertScheduleRequestDTO){
        boolean checkTokenValidation = jwtProvider.validateToken(concertScheduleRequestDTO.getToken() , concertScheduleRequestDTO.getUserId());
        if(checkTokenValidation){
            return concertScheduleRepository.findAllByIdConcertIdAfterDate(concertScheduleRequestDTO.getConcertId(), concertScheduleRequestDTO.getSelectedDate());
        } else {
            //TODO: 글로벌로 exception 처리 만들기
            throw new RuntimeException("토큰 확인 필요");
        }

    }
}
