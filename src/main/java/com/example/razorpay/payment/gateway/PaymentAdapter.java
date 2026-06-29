package com.example.razorpay.payment.gateway;

import com.example.razorpay.payment.gateway.dto.PaymentRequest;
import com.example.razorpay.payment.gateway.dto.PaymentResult;

public interface PaymentAdapter {



    PaymentResult initiate(PaymentRequest request);
}
