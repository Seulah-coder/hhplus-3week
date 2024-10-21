
package com.hhplus.hhplus3week.app.concertSchedule.controller;

import com.hhplus.hhplus3week.app.concertSchedule.dto.ConcertScheduleRequestDTO;

import com.hhplus.hhplus3week.app.concertSchedule.models.ConcertSchedule;
import com.hhplus.hhplus3week.app.concertSchedule.services.ConcertScheduleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/concertSchedules")
@Tag(name = "콘서트 스케줄 api")
@AllArgsConstructor
public class ConcertScheduleController {

    private final ConcertScheduleService concertScheduleService;

    /**
     * 콘서트 아이디에 따른 예약 가능한 스케줄을 조회한다
     * @return
     */
    @GetMapping("/{concertId}")
    public ResponseEntity<List<ConcertSchedule>> getConcertScheduleByConcertIdAfterDate(ConcertScheduleRequestDTO concertScheduleRequestDTO) {
        List<ConcertSchedule> concertScheduleList = concertScheduleService.getConcertScheduleByConcertIdAfterDate(concertScheduleRequestDTO);
        return ResponseEntity.ok(concertScheduleList);
    }

    /**
     * 아이디에 따른 특정 콘서트 상세 정보를 조회한다.
     * @return
     */
    @GetMapping("/detail/{id}")
    public ResponseEntity<ConcertSchedule> getConcertScheduleById(@PathVariable("id") Long id){
        ConcertSchedule concert = concertScheduleService.getConcertScheduleById(id);
        return ResponseEntity.ok(concert);
    }

    @GetMapping("/seat/{id}")
    public ResponseEntity<ConcertSchedule> getConcertScheduleByIdWithSeat(ConcertScheduleRequestDTO concertScheduleRequestDTO){
        ConcertSchedule concertSchedule = concertScheduleService.getConcertScheduleByIdWithAvailableSeats(concertScheduleRequestDTO);
        return ResponseEntity.ok(concertSchedule);
    }
}
