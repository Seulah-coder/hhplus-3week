package com.hhplus.hhplus3week.app.waitingQueue.controller;

import com.hhplus.hhplus3week.app.waitingQueue.dto.WaitingQueueRequestDTO;
import com.hhplus.hhplus3week.app.waitingQueue.models.WaitingQueue;
import com.hhplus.hhplus3week.app.waitingQueue.services.WaitingQueueService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "토큰 api")
@RequestMapping("/api/waitings")
public class WaitingQueueController {

    private final WaitingQueueService waitingQueueService;

    public WaitingQueueController(WaitingQueueService waitingQueueService) {
        this.waitingQueueService = waitingQueueService;
    }

    @PostMapping("/request")
    public ResponseEntity<WaitingQueue> requestWaitingQueue(WaitingQueueRequestDTO waitingQueueRequestDTO){
        WaitingQueue waitingQueue= waitingQueueService.createWaitingQueue(waitingQueueRequestDTO);
        return ResponseEntity.ok(waitingQueue);
    }

    @PostMapping("/update")
    public ResponseEntity<WaitingQueue> updateWaitingQueue(WaitingQueueRequestDTO waitingQueueRequestDTO){
        WaitingQueue waitingQueue= waitingQueueService.updateWaitingQueue(waitingQueueRequestDTO);
        return ResponseEntity.ok(waitingQueue);
    }

    /**
     * 폴링용 API
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<WaitingQueue> getWaitingQueueById(@PathVariable("id") Long id){
        return ResponseEntity.ok(waitingQueueService.getWaitingQueueById(id));
    }
}
