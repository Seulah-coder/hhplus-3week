package com.hhplus.hhplus3week.app.waitingQueue.controller;

import com.hhplus.hhplus3week.app.waitingQueue.dto.WaitingQueueDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "토큰 api")
@RequestMapping("/api/tokens")
public class WaitingQueueController {

    @PostMapping("/request")
    public ResponseEntity<WaitingQueueDTO> requestWaitingQueue(WaitingQueueDTO waitingQueueDTO){
        return ResponseEntity.ok(waitingQueueDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WaitingQueueDTO> getWaitingQueueById(@PathVariable("id") Long id){
        return ResponseEntity.ok(new WaitingQueueDTO());
    }
}
