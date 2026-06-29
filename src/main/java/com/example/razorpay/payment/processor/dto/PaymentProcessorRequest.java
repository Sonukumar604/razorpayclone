package com.example.razorpay.payment.processor.dto;

import com.example.razorpay.common.enums.PaymentMethod;
import com.example.razorpay.common.enums.entity.Money;

import java.util.Map;

public record PaymentProcessorRequest(
        PaymentMethod method,
        Money amount,

        Map<String, Object> methodDetails
) {
}
