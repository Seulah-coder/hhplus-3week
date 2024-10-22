package com.hhplus.hhplus3week.app.booking.controller;
import com.hhplus.hhplus3week.app.booking.application.BookingPaymentFacade;
import com.hhplus.hhplus3week.app.booking.application.BookingSeatFacade;
import com.hhplus.hhplus3week.app.booking.dto.BookingSaveDTO;
import com.hhplus.hhplus3week.app.booking.models.Booking;
import com.hhplus.hhplus3week.app.booking.services.BookingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/bookings")
@Tag(name = "예약 api")
@AllArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    private final BookingPaymentFacade bookingPaymentFacade;

    private final BookingSeatFacade bookingSeatFacade;

    @Operation(summary="예약 내역 조회", description="id로 예약 내역을 가져온다")
    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable("id") Long id){
        Booking booking = bookingService.getbookingById(id);
        return ResponseEntity.ok(booking);
    }


    @Operation(summary="예약 요청", description="콘서트 예약을 요청한다")
    @PostMapping("/seat")
    public ResponseEntity<Booking> requestBookingSeat(@RequestBody BookingSaveDTO bookingSaveDTO){
        Booking booking = bookingSeatFacade.requestBookingSelectedSeat(bookingSaveDTO);
        return ResponseEntity.ok(booking);
    }




}
