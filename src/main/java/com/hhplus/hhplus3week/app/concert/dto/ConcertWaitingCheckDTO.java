package com.hhplus.hhplus3week.app.concert.dto;

import com.hhplus.hhplus3week.app.concert.models.Concert;
import com.hhplus.hhplus3week.app.waitingQueue.models.WaitingQueue;
import lombok.Data;

@Data
public class ConcertWaitingCheckDTO {

    Concert concert;
    WaitingQueue waitingQueue;
    String token;
}
