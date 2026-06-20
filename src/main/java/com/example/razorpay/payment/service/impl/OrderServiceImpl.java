package com.example.razorpay.payment.service.impl;

import com.example.razorpay.common.enums.OrderStatus;
import com.example.razorpay.common.exception.DuplicateResourceException;
import com.example.razorpay.payment.dto.request.CreateOrderRequest;
import com.example.razorpay.payment.dto.response.OrderResponse;
import com.example.razorpay.payment.entity.OrderRecord;
import com.example.razorpay.payment.repository.OrderRepository;
import com.example.razorpay.payment.service.OrderService;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Value("${payment.order.default-order-expiry-minutes : 30}")
    private int defaultOrderExpiryMinutes;

    @Override
    public OrderResponse create(UUID merchantId, CreateOrderRequest request) {
        if( request.receipt() != null && orderRepository.existsByMerchantIdAndReceipt(merchantId, request.receipt())){
            throw new DuplicateResourceException("DUPLICATE_ORDER_RECEIPT", "Order with receipt already exists: " + request.receipt());
        }
        OrderRecord order = OrderRecord.builder()
                .receipt(request.receipt())
                .amount(request.amount())
                .notes(request.notes())

                .merchantId(merchantId)
                .orderStatus(OrderStatus.CREATED)
                .expiresAt(request.expiresAt() != null ? request.expiresAt() :
                        LocalDateTime.now().plusMinutes(defaultOrderExpiryMinutes))
                .build();
        order = orderRepository.save(order);
        return new OrderResponse(order.getId(), order.getMerchantId(),order.getReceipt(), order.getAmount(), order.getOrderStatus(), order.getAttempts(), order.getNotes(), order.getExpiresAt(), null);

    }
}
