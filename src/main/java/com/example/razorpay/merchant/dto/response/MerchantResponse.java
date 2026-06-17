package com.example.razorpay.merchant.dto.response;

import com.example.razorpay.common.enums.MerchantStatus;

import java.util.UUID;

public record MerchantResponse(
        UUID id,
        String name,
        String email,
        String businessType,
        com.example.razorpay.common.enums.BusinessType type, MerchantStatus merchantStatus
) {
}
