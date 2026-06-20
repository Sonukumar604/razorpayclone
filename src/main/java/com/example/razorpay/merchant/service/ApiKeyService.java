package com.example.razorpay.merchant.service;

import com.example.razorpay.merchant.dto.request.CreateApiKeyRequest;
import com.example.razorpay.merchant.dto.response.ApiKeyCreateResponse;
import com.example.razorpay.merchant.dto.response.ApiKeyResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

public interface ApiKeyService {

    ApiKeyCreateResponse create(UUID merchantId, CreateApiKeyRequest request);

    List<ApiKeyResponse> listByMerchant(UUID merchantId);

    void revoke(UUID merchandId, UUID keyId);

    ApiKeyCreateResponse rotate(UUID merchantId, UUID keyId);
}
