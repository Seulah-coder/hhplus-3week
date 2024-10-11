package com.hhplus.hhplus3week.api.booking.controller;

import com.hhplus.hhplus3week.api.booking.dto.BookingDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/booking")
@Tag(name = "예약 api")
public class BookingController {

    /**
     * 아이디로 예약 내역을 가져온다
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<BookingDTO> getBookingById(@PathVariable("id") Long id){
        BookingDTO booking = new BookingDTO();
        return ResponseEntity.ok(booking);
    }

    /**
     * 예약 신청
     * @param bookingDTO
     * @return
     */
    @PostMapping("/request")
    public ResponseEntity<BookingDTO> requestBooking(@RequestBody BookingDTO bookingDTO){
        return ResponseEntity.ok(bookingDTO);
    }

    /**
     * 예약 내역들 조회
     * @return
     */
    @GetMapping("/list/{userId}")
    public ResponseEntity<List<BookingDTO>> getConcertById(@PathVariable("userId") Long userId){
        List<BookingDTO> bookingList = new ArrayList<>();
        return ResponseEntity.ok(bookingList);
    }



}
