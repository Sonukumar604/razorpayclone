package com.example.razorpay.operations.entity;

import com.example.razorpay.common.enums.entity.BaseEntity;
import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public class SettlementPaymentId extends BaseEntity {
    private UUID settlementId;

    private UUID paymentId;
}
