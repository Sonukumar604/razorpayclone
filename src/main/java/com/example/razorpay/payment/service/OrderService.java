package com.example.razorpay.payment.service;

import com.example.razorpay.payment.dto.request.CreateOrderRequest;
import com.example.razorpay.payment.dto.response.OrderResponse;
import org.jspecify.annotations.Nullable;

import java.util.UUID;

public interface OrderService {

    OrderResponse create(UUID merchantId, CreateOrderRequest request);
}
