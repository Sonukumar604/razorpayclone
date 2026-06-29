package com.example.razorpay.payment.gateway.adapter;

import com.example.razorpay.payment.gateway.PaymentAdapter;
import com.example.razorpay.payment.gateway.dto.PaymentRequest;
import com.example.razorpay.payment.gateway.dto.PaymentResult;

public class CardPaymentAdapter implements PaymentAdapter {

    @Override
    public PaymentResult initiate(PaymentRequest request){
        return null;
    }
}
