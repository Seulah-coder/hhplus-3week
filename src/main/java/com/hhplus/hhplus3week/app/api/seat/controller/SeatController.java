package com.hhplus.hhplus3week.app.api.seat.controller;

import com.hhplus.hhplus3week.app.api.seat.dto.SeatDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/seat")
@Tag(name = "좌석 api")
public class SeatController {

    /**
     * 콘서트 스케줄 아이디에 따른 예약 가능한 좌석 수를 조회한다.
     * @return
     */
    @GetMapping("/{concertScheduleId}")
    public ResponseEntity<List<SeatDTO>> getSeatListByScheduleId(@PathVariable("concertScheduleId") Long concertScheduleId){
        List<SeatDTO> seatList = List.of();
        return ResponseEntity.ok(seatList);
    }

    /**
     * 아이디에 따른 좌석 상세 정보를 조회한다.
     * @return
     */
    @GetMapping("/detail/{id}")
    public ResponseEntity<SeatDTO> getSeatById(@PathVariable("id") Long id){
        SeatDTO seat = new SeatDTO();
        return ResponseEntity.ok(seat);
    }
}
