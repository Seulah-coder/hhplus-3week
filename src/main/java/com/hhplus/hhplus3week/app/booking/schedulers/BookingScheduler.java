package com.hhplus.hhplus3week.app.booking.schedulers;

import com.hhplus.hhplus3week.app.booking.services.BookingService;
import com.hhplus.hhplus3week.app.seat.models.SeatStatus;
import com.hhplus.hhplus3week.app.seat.services.SeatService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class BookingScheduler {


    private final ScheduledExecutorService scheduler;
    private final BookingService bookingService;
    private final SeatService seatService;

    public BookingScheduler(BookingService bookingService, SeatService seatService) {
        this.scheduler = Executors.newSingleThreadScheduledExecutor();
        this.bookingService = bookingService;
        this.seatService = seatService;
    }

    public void startScheduler() {
        // 만료된 항목 제거 스케줄러
        scheduler.scheduleAtFixedRate(
                this::removeExpiredBookings,
                0,
                1,
                TimeUnit.MINUTES
        );
    }

    @Transactional
    protected void removeExpiredBookings() {
        try{
            LocalDateTime now = LocalDateTime.now();

            List<Long> seatIds = bookingService.getSeatIdsFromExpiredBooking(now);

            for (Long seatId : seatIds) {
                seatService.updateSeatStatus(seatId, SeatStatus.AVAILABLE);
            }

            bookingService.deleteTempExpireTimeBooking(now);

        }catch (Exception e){
            log.error("에러 발생 ", e);
        }
    }

    public void stopScheduler() {
        try {
            scheduler.shutdown();
            if (!scheduler.awaitTermination(1, TimeUnit.MINUTES)) {
                scheduler.shutdownNow();
            }
        } catch (InterruptedException e) {
            scheduler.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }


}
