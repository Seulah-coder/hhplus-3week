package com.hhplus.hhplus3week.app.payment.controller;


import com.hhplus.hhplus3week.app.payment.dto.PaymentRequestDTO;
import com.hhplus.hhplus3week.app.payment.models.Payment;
import com.hhplus.hhplus3week.app.payment.services.PaymentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/payments")
@Tag(name = "결제 api")
@AllArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    /**
     * 결제 요청을 한다
     * @return
     */
    @PostMapping("/")
    public ResponseEntity<Payment> requestPayment(@RequestBody PaymentRequestDTO paymentRequestDTO){
        Payment payment = paymentService.savePayment(paymentRequestDTO);
        return ResponseEntity.ok(payment);
    }

    /**
     * 아이디에 따른 결제 정보를 조회한다
     * @return
     */
    @GetMapping("/detail/{id}")
    public ResponseEntity<Payment> getPaymentDetailById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPayment(id);
        return ResponseEntity.ok(payment);
    }
}
