package com.hhplus.hhplus3week.app.booking.services;

import com.hhplus.hhplus3week.app.booking.dto.BookingRequestDTO;
import com.hhplus.hhplus3week.app.booking.models.Booking;
import com.hhplus.hhplus3week.app.booking.repositories.BookingRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    
    public Booking getbookingById(Long id){
        return bookingRepository.findById(id).orElseThrow(() -> new RuntimeException("아이디에 해당하는 예약건이 없습니다."));
    }

    public List<Booking> getBookingListByConcertScheduleId(Long concertScheduleId){
        return bookingRepository.findAllByConcertScheduleId(concertScheduleId);
    }


    @Transactional
    public Booking saveBooking(BookingRequestDTO bookingRequestDTO) {
        Booking booking = Booking.builder()
                .bookingStatus(bookingRequestDTO.getBookingStatus())
                .price(bookingRequestDTO.getPrice())
                .concertName(bookingRequestDTO.getConcertName())
                .bookingTime(LocalDateTime.now())
                .concertDate(bookingRequestDTO.getConcertDate())
                .seatId(bookingRequestDTO.getSeatId())
                .paymentId(bookingRequestDTO.getPaymentId())
                .tempUserId(bookingRequestDTO.getUserId())
                .userId(bookingRequestDTO.getUserId())
                .seatNumber(bookingRequestDTO.getSeatNumber())
                .concertScheduleId(bookingRequestDTO.getConcertScheduleId())
                .id(bookingRequestDTO.getId())
                .build();

        return bookingRepository.save(booking);
    }
}
