package com.example.razorpay.payment.service;

import com.example.razorpay.payment.dto.request.PaymentInitRequest;
import com.example.razorpay.payment.dto.response.PaymentResponse;

import java.util.UUID;

public interface PaymentService {

    PaymentResponse initiate(UUID merchantId, PaymentInitRequest request);
}
