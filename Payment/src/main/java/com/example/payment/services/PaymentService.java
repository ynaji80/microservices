package com.example.payment.services;

import com.example.payment.domain.Payment;

import java.util.List;

public interface PaymentService {
    public List<Payment> getAllPayments();
    public Payment processPayment(Payment payment);
}
