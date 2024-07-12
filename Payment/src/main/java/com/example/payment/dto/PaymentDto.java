package com.example.payment.dto;

import lombok.Data;
@Data
public class PaymentDto {
    private Long orderId;
    private String creditCard;
    private Double amount;
}