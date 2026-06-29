package com.example.razorpay.payment.config;

import com.example.razorpay.common.enums.PaymentMethod;
import com.example.razorpay.payment.gateway.adapter.CardPaymentAdapter;
import com.example.razorpay.payment.gateway.adapter.NetBankingAdapter;
import com.example.razorpay.payment.gateway.adapter.UpiPaymentAdapter;
import com.example.razorpay.payment.gateway.PaymentAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class PaymentAdapterConfig {
    @Bean
    public Map<PaymentMethod, PaymentAdapter> paymentAdapterMap(){
        return Map.of(
                PaymentMethod.CARD, new CardPaymentAdapter(),
                PaymentMethod.NETBANKING, new NetBankingAdapter(),
                PaymentMethod.UPI, new UpiPaymentAdapter()
        );
    }
}
