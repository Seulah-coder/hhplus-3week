
package com.hhplus.hhplus3week.app.seat.controller;

import com.hhplus.hhplus3week.app.seat.application.SeatConcertScheduleFacade;
import com.hhplus.hhplus3week.app.seat.dto.SeatDTO;

import com.hhplus.hhplus3week.app.seat.dto.SeatSaveDTO;
import com.hhplus.hhplus3week.app.seat.models.Seat;
import com.hhplus.hhplus3week.app.seat.services.SeatService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.ServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seats")
@Tag(name = "좌석 api")
@AllArgsConstructor
public class SeatController {

    private final SeatService seatService;

    private final SeatConcertScheduleFacade seatConcertScheduleFacade;

    @PostMapping("/")
    public ResponseEntity<Seat> saveSeat(@RequestBody SeatSaveDTO seatSaveDTO) {
        Seat seat = seatService.saveSeat(seatSaveDTO);
        return ResponseEntity.ok(seat);
    }

    /**
     * 아이디에 따른 좌석 상세 정보를 조회한다.
     * @return
     */
    @GetMapping("/detail/{id}")
    public ResponseEntity<Seat> getSeatById(@PathVariable("id") Long id){
        Seat seat = seatService.getSeatbyIdWithLock(id);
        return ResponseEntity.ok(seat);
    }
}
