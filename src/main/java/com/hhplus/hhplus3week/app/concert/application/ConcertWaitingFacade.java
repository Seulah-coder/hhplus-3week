package com.hhplus.hhplus3week.app.concert.application;

import com.hhplus.hhplus3week.app.common.JwtProvider;
import com.hhplus.hhplus3week.app.concert.dto.ConcertWaitingCheckDTO;
import com.hhplus.hhplus3week.app.concert.services.ConcertService;
import com.hhplus.hhplus3week.app.waitingQueue.dto.WaitingQueueRequestDTO;
import com.hhplus.hhplus3week.app.waitingQueue.models.WaitingQueue;
import com.hhplus.hhplus3week.app.waitingQueue.services.WaitingQueueService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ConcertWaitingFacade {

    private final ConcertService concertService;
    private final WaitingQueueService waitingQueueService;
    private final JwtProvider jwtProvider;

    @Transactional
    public ConcertWaitingCheckDTO checkWaitingQueueGetConcertById(Long concertId, Long userId) {
        ConcertWaitingCheckDTO response = new ConcertWaitingCheckDTO();

        try {
            boolean hasWaitingOrder = waitingQueueService.checkWaitingOrderByConcertId(concertId) > 0;
            WaitingQueue waitingQueue = waitingQueueService.getWaitingQueueByUserId(userId);

            if (waitingQueue == null && hasWaitingOrder) {
                WaitingQueueRequestDTO waitingQueueRequestDTO = new WaitingQueueRequestDTO(concertId, userId);
                response.setWaitingQueue(waitingQueueService.saveWaitingQueue(waitingQueueRequestDTO));
            } else if (waitingQueue != null && "pass".equals(waitingQueue.getTokenStatus())) {
                response.setConcert(concertService.getConcertIdWithScheduleByConcertId(concertId));
            } else if (!hasWaitingOrder) {
                response.setConcert(concertService.getConcertIdWithScheduleByConcertId(concertId));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }
}
