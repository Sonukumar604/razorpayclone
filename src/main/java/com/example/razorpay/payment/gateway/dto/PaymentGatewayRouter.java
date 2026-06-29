package com.example.razorpay.payment.gateway.dto;


import com.example.razorpay.common.enums.PaymentMethod;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class PaymentGatewayRouter {

    private final Map<PaymentMethod, PaymentAdapter> paymentAdapters;

    public void initiate(PaymentRequest request){
        PaymentAdapter adapter = paymentAdapters.get(request.method());
        if(adapter == null){
            throw new IllegalArgumentException("No payment adapter found for method: " + request.method());
        }
        adapter.initiate(request);

    }
}
