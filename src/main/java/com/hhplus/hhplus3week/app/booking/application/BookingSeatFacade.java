package com.hhplus.hhplus3week.app.booking.application;

import com.hhplus.hhplus3week.app.booking.dto.BookingSaveDTO;
import com.hhplus.hhplus3week.app.booking.models.Booking;
import com.hhplus.hhplus3week.app.booking.models.BookingStatus;
import com.hhplus.hhplus3week.app.booking.services.BookingService;
import com.hhplus.hhplus3week.app.common.JwtProvider;
import com.hhplus.hhplus3week.app.money.models.Money;
import com.hhplus.hhplus3week.app.money.services.MoneyService;
import com.hhplus.hhplus3week.app.payment.dto.PaymentRequestDTO;
import com.hhplus.hhplus3week.app.payment.models.Payment;
import com.hhplus.hhplus3week.app.payment.services.PaymentService;
import com.hhplus.hhplus3week.app.seat.models.SeatStatus;
import com.hhplus.hhplus3week.app.seat.services.SeatService;
import com.hhplus.hhplus3week.app.waitingQueue.models.WaitingQueue;
import com.hhplus.hhplus3week.app.waitingQueue.services.WaitingQueueService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BookingSeatFacade {

    //TODO: 이렇게 한군데에서 다양한 서비스를 불러오는게 맞는건지..?

    private final BookingService bookingService;
    private final SeatService seatService;
    private final WaitingQueueService waitingQueueService;
    private final JwtProvider jwtProvider;

    private final MoneyService moneyService;
    private final PaymentService paymentService;


    @Transactional
    public Booking requestBookingSelectedSeat(BookingSaveDTO bookingSaveDTO) {
        WaitingQueue waitingQueue = waitingQueueService.getWaitingQueueByUserId(bookingSaveDTO.getUserId());

        if (!jwtProvider.validateToken(waitingQueue.getToken(), bookingSaveDTO.getUserId())) {
            throw new RuntimeException("유효하지 않은 토큰");
        }

        Booking booking = bookingSaveDTO.getId() > 0 ? bookingService.getbookingById(bookingSaveDTO.getId()) : null;

        try {
            seatService.updateSeatStatus(bookingSaveDTO.getSeatId(), SeatStatus.PENDING);
            bookingSaveDTO.setBookingStatus(BookingStatus.PENDING);
            booking = bookingService.createBooking(bookingSaveDTO);

            Money money = moneyService.getMoneyWithLock(bookingSaveDTO.getUserId());
            if (money.getCurrentAmount() <= bookingSaveDTO.getPrice()) {
                throw new RuntimeException("잔고 부족");
            }

            PaymentRequestDTO paymentRequestDTO  = new PaymentRequestDTO();
            paymentRequestDTO.setBookingId(booking.getId());
            paymentRequestDTO.setAmount(bookingSaveDTO.getPrice());
            paymentRequestDTO.setUserId(bookingSaveDTO.getUserId());
            paymentRequestDTO.setToken(waitingQueue.getToken());
            Payment payment = paymentService.savePayment(paymentRequestDTO);

            if (payment.getId() > 0) {
                bookingService.updateBookingStatus(booking.getId(), BookingStatus.COMPLETE);
                seatService.updateSeatStatus(bookingSaveDTO.getSeatId(), SeatStatus.RESERVED);
                waitingQueueService.deleteWaitingQueueById(waitingQueue.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return booking;
    }

    public void updateSeatStatus(Long seatId, SeatStatus seatStatus) {
        seatService.updateSeatStatus(seatId, seatStatus);
    }

}
