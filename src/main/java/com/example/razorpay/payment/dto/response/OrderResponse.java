package com.example.razorpay.payment.dto.response;

import com.example.razorpay.common.enums.OrderStatus;
import com.example.razorpay.common.enums.entity.Money;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

public record OrderResponse(
        UUID id,
        UUID merchantId,
        String receipt,
        Money Amount,
        OrderStatus status,
        Integer attempts,
        Map<String, Object> notes,
        LocalDateTime expiresAt,
        LocalDateTime createdAt
) {
}
