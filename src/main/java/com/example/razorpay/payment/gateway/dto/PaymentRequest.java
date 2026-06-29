package com.example.razorpay.payment.gateway.dto;

import com.example.razorpay.common.enums.PaymentMethod;
import com.example.razorpay.common.enums.entity.Money;

import java.util.Map;
import java.util.UUID;

public record PaymentRequest(
        UUID paymentId,
        UUID orderId,
        UUID merchantId,
        Money amount,
        PaymentMethod method,
        Map<String, Object> methodDetails
) {

}
