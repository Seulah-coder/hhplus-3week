
package com.hhplus.hhplus3week.app.seat.controller;

import com.hhplus.hhplus3week.app.seat.dto.SeatSaveDTO;
import com.hhplus.hhplus3week.app.seat.models.Seat;
import com.hhplus.hhplus3week.app.seat.services.SeatService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/seats")
@Tag(name = "좌석 api")
@AllArgsConstructor
public class SeatController {

    private final SeatService seatService;

    @PostMapping("/")
    public void saveSeat(@RequestBody SeatSaveDTO seatSaveDTO) {
        seatService.createInitSeat(seatSaveDTO);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Seat> getSeatById(@PathVariable("id") Long id){
        Seat seat = seatService.getSeatByIdWithLock(id);
        return ResponseEntity.ok(seat);
    }
}
