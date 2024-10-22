package com.hhplus.hhplus3week.app.booking.schedulers;

import com.hhplus.hhplus3week.app.booking.repositories.BookingRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class BookingScheduler {

    private final EntityManager entityManager;
    private final ScheduledExecutorService scheduler;
    private final BookingRepository bookingRepository;

    //TODO: facade를 여기서 가져오는게 맞는지?

    public BookingScheduler(EntityManager entityManager,BookingRepository bookingRepository) {
        this.scheduler = Executors.newSingleThreadScheduledExecutor();
        this.entityManager = entityManager;
        this.bookingRepository = bookingRepository;
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

            String jpql = "DELETE FROM Booking b WHERE b.tempExpireTime <: now";
            int deleteCount = entityManager.createQuery(jpql)
                    .setParameter("now", now)
                    .executeUpdate();

            log.info("{} 개 삭제됨", deleteCount);

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
