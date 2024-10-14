package com.hhplus.hhplus3week.app.booking.controller;
import com.hhplus.hhplus3week.app.booking.dto.BookingDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/bookings")
@Tag(name = "예약 api")
public class BookingController {

    @Operation(summary="예약 내역 조회", description="id로 예약 내역을 가져온다")
    @GetMapping("/{id}")
    public ResponseEntity<BookingDTO> getBookingById(@PathVariable("id") Long id){
        BookingDTO booking = new BookingDTO();
        return ResponseEntity.ok(booking);
    }


    @PostMapping("/")
    public ResponseEntity<BookingDTO> requestBooking(@RequestBody BookingDTO bookingDTO){
        return ResponseEntity.ok(bookingDTO);
    }




}
