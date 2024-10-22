package com.hhplus.hhplus3week.app.booking.services;

import com.hhplus.hhplus3week.app.booking.dto.BookingSaveDTO;
import com.hhplus.hhplus3week.app.booking.models.Booking;
import com.hhplus.hhplus3week.app.booking.models.BookingStatus;
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
    public Booking createBooking(BookingSaveDTO bookingSaveDTO) {
        Booking booking = Booking.builder()
                .bookingStatus(bookingSaveDTO.getBookingStatus())
                .price(bookingSaveDTO.getPrice())
                .concertName(bookingSaveDTO.getConcertName())
                .bookingTime(LocalDateTime.now())
                .concertDate(bookingSaveDTO.getConcertDate())
                .seatId(bookingSaveDTO.getSeatId())
                .paymentId(bookingSaveDTO.getPaymentId())
                .tempUserId(bookingSaveDTO.getUserId())
                .userId(bookingSaveDTO.getUserId())
                .seatNumber(bookingSaveDTO.getSeatNumber())
                .concertScheduleId(bookingSaveDTO.getConcertScheduleId())
                .id(bookingSaveDTO.getId())
                .tempUserId(bookingSaveDTO.getUserId())
                .tempExpireTime(LocalDateTime.now().plusMinutes(5))
                .build();

        return bookingRepository.save(booking);
    }

    @Transactional
    public Booking updateBooking(BookingSaveDTO bookingSaveDTO) {

        Booking booking = this.getbookingById(bookingSaveDTO.getId());
        Booking newBookingData = Booking.builder()
                .bookingStatus(bookingSaveDTO.getBookingStatus())
                .price(bookingSaveDTO.getPrice())
                .concertName(bookingSaveDTO.getConcertName())
                .bookingTime(bookingSaveDTO.getBookingTime())
                .concertDate(bookingSaveDTO.getConcertDate())
                .seatId(bookingSaveDTO.getSeatId())
                .paymentId(bookingSaveDTO.getPaymentId())
                .tempUserId(bookingSaveDTO.getUserId())
                .userId(bookingSaveDTO.getUserId())
                .seatNumber(bookingSaveDTO.getSeatNumber())
                .concertScheduleId(bookingSaveDTO.getConcertScheduleId())
                .id(booking.getId())
                .tempUserId(bookingSaveDTO.getTempUserId())
                .tempExpireTime(bookingSaveDTO.getTempExpiredTime())
                .build();

        return bookingRepository.save(newBookingData);
    }

    @Transactional
    public Booking updateBookingStatus(Long bookingId, BookingStatus status) {

        Booking booking = this.getbookingById(bookingId);
        Booking newBookingData = Booking.builder()
                .id(booking.getId())
                .bookingStatus(status)
                .build();

        return bookingRepository.save(newBookingData);
    }
}
