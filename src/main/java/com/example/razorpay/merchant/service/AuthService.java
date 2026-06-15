package com.example.razorpay.merchant.service;

import com.example.razorpay.merchant.dto.request.MerchantSignupRequest;
import com.example.razorpay.merchant.dto.response.MerchantResponse;
import jakarta.validation.Valid;
import org.jspecify.annotations.Nullable;

public interface AuthService {
    MerchantResponse signup(MerchantSignupRequest request);
}
