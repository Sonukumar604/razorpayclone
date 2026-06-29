package com.example.razorpay.payment.gateway.dto;

import com.example.razorpay.common.enums.PaymentMethod;

import java.util.Map;

public interface PaymentAdapter {



    void initiate(PaymentRequest request);
}
