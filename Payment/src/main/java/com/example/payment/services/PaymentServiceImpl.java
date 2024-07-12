package com.example.payment.services;

import com.example.payment.domain.Payment;
import com.example.payment.repository.PaymentRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepo paymentRepository;
    @Override
    public List<Payment> getAllPayments(){
        return paymentRepository.findAll();
    }
    public Payment processPayment(Payment payment) {
        // Simulate fraud detection
        if (isFraud(payment.getCreditCard(), payment.getAmount())) {
            payment.setStatus("DECLINED");
        } else {
            payment.setStatus("APPROVED");
        }
        return paymentRepository.save(payment);
    }

    private boolean isFraud(String creditCard, Double amount) {
        Character[] firstDigit = {'2','4','5','3'};
        return !Arrays.asList(firstDigit).contains(creditCard.charAt(0)) || amount >3000;
    }

}
