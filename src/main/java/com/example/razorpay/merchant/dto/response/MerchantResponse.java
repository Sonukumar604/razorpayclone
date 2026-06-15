package com.example.razorpay.merchant.dto.response;

import com.example.razorpay.common.enums.MerchantStatus;
import com.example.razorpay.merchant.entity.Merchant;

import java.util.UUID;

public record MerchantResponse(
        UUID id,
        String name,
        String email,
        String businessType,
        MerchantStatus merchantStatus
) {
}
