package com.hhplus.hhplus3week.app.money.controller;

import com.hhplus.hhplus3week.app.money.dto.MoneyDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/money")
@Tag(name = "잔고 api")
public class MoneyController {

    /**
     * 결제 가능한 금액을 조회한다.
     * @return
     */
    @PostMapping("/check")
    public ResponseEntity<MoneyDTO> requestPayment(@RequestBody MoneyDTO moneyDTO){
        MoneyDTO money = new MoneyDTO();
        return ResponseEntity.ok(money);
    }

    /**
     * 잔고를 사용한다
     * @return
     */
    @PostMapping("/use")
    public ResponseEntity<MoneyDTO> useMoney(MoneyDTO moneyDTO){
        MoneyDTO money = new MoneyDTO();
        return ResponseEntity.ok(money);
    }

    /**
     * 잔고를 충전한다
     * @param moneyDTO
     * @return
     */
    @PostMapping("/charge")
    public ResponseEntity<MoneyDTO> chargeMoney(MoneyDTO moneyDTO){
        MoneyDTO money = new MoneyDTO();
        return ResponseEntity.ok(money);
    }
}
