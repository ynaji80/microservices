package com.example.payment.controller;

import com.example.payment.domain.Payment;
import com.example.payment.dto.PaymentDto;
import com.example.payment.repository.PaymentRepo;
import com.example.payment.services.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/payment")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @GetMapping("/")
    public ResponseEntity<List<Payment>> getPayments(){
        return new ResponseEntity<>(paymentService.getAllPayments(),
                HttpStatus.OK);
    }
    @PostMapping("/process")
    public ResponseEntity<Payment>  processPayment(@RequestBody PaymentDto paymentDto) {
        Payment payment = new Payment();
        payment.setOrderId(paymentDto.getOrderId());
        payment.setAmount(paymentDto.getAmount());
        payment.setCreditCard(paymentDto.getCreditCard());
        return new ResponseEntity<>(paymentService.processPayment(payment),HttpStatus.CREATED);
    }
}
