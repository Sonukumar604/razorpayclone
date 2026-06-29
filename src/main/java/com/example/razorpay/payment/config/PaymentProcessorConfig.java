package com.example.razorpay.payment.config;

import com.example.razorpay.common.enums.PaymentMethod;
import com.example.razorpay.payment.processor.PaymentProcessor;
import com.example.razorpay.payment.processor.strategy.CardPaymentProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class PaymentProcessorConfig {

    @Bean
    public Map<PaymentMethod, PaymentProcessor> paymentProcessorMap(){
        return Map.of(
                PaymentMethod.CARD, new CardPaymentProcessor(),
                PaymentMethod.NETBANKING, new CardPaymentProcessor(),
                PaymentMethod.UPI, new CardPaymentProcessor()
        );
    }

}
