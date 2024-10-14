package com.hhplus.hhplus3week.app.payment.controller;


import com.hhplus.hhplus3week.app.payment.dto.PaymentDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/payment")
@Tag(name = "결제 api")
public class PaymentController {

    /**
     * 결제 요청을 한다
     * @return
     */
    @PostMapping("/")
    public ResponseEntity<PaymentDTO> requestPayment(@RequestBody PaymentDTO paymentDTO){
        PaymentDTO payment = new PaymentDTO();
        return ResponseEntity.ok(payment);
    }

    /**
     * 아이디에 따른 결제 정보를 조회한다
     * @return
     */
    @GetMapping("/detail/{id}")
    public ResponseEntity<PaymentDTO> getPaymentDetailById(@PathVariable("id") Long id){
        PaymentDTO payment = new PaymentDTO();
        return ResponseEntity.ok(payment);
    }
}
