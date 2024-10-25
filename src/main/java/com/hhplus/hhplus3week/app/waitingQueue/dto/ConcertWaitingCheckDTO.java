package com.hhplus.hhplus3week.app.waitingQueue.dto;
import com.hhplus.hhplus3week.app.waitingQueue.models.WaitingStatus;
import lombok.Data;

@Data
public class ConcertWaitingCheckDTO {

    WaitingStatus waitingQueteStatus;
    String token;
}
