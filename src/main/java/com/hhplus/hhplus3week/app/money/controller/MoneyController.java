package com.hhplus.hhplus3week.app.money.controller;

import com.hhplus.hhplus3week.app.money.dto.MoneyDTO;
import com.hhplus.hhplus3week.app.money.models.Money;
import com.hhplus.hhplus3week.app.money.services.MoneyService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/money")
@Tag(name = "잔고 api")
@AllArgsConstructor
public class MoneyController {

    private final MoneyService moneyService;

    /**
     * 결제 가능한 금액을 조회한다.
     * @return
     */
    @GetMapping("/check/{userId}")
    public ResponseEntity<Money> getPayment(@PathVariable("userId") Long userId){
        Money money = moneyService.getMoneyByUserId(userId);
        return ResponseEntity.ok(money);
    }

    /**
     * 잔고를 사용한다
     * @return
     */
    @PostMapping("/use")
    public ResponseEntity<Money> useMoney(MoneyDTO moneyDTO){
        Money money = moneyService.useMoney(moneyDTO);
        return ResponseEntity.ok(money);
    }

    /**
     * 잔고를 충전한다
     * @param moneyDTO
     * @return
     */
    @PostMapping("/charge")
    public ResponseEntity<Money> chargeMoney(MoneyDTO moneyDTO){
        Money money = moneyService.chargeMoney(moneyDTO);
        return ResponseEntity.ok(money);
    }
}
