package com.example.razorpay.merchant.service.impl;

import com.example.razorpay.common.exception.ResourceNotFoundException;
import com.example.razorpay.common.util.RandomizerUtil;
import com.example.razorpay.merchant.dto.request.CreateApiKeyRequest;
import com.example.razorpay.merchant.dto.response.ApiKeyCreateResponse;
import com.example.razorpay.merchant.dto.response.ApiKeyResponse;
import com.example.razorpay.merchant.entity.ApiKey;
import com.example.razorpay.merchant.entity.Merchant;
import com.example.razorpay.merchant.mapper.ApiKeyMapper;
import com.example.razorpay.merchant.repository.ApiKeyRepository;
import com.example.razorpay.merchant.repository.MerchantRepository;
import com.example.razorpay.merchant.service.ApiKeyService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ApiKeyServiceimpl implements ApiKeyService {

    private final MerchantRepository merchantRepository;
    private final ApiKeyRepository apiKeyRepository;
    private final ApiKeyMapper apiKeyMapper;

    @Override
    @Transactional
    public ApiKeyCreateResponse create(UUID merchantId, CreateApiKeyRequest request) {
        Merchant merchant = merchantRepository.findById(merchantId).orElseThrow(() -> new ResourceNotFoundException("merchant" ,merchantId));

        String keyId = "rzp_" + request.environment().name().toLowerCase() +"_" + RandomizerUtil.randomBase64(24);
        String rawSecret = RandomizerUtil.randomBase64(40);
        ApiKey key = ApiKey.builder()
                .merchant(merchant)
                .keyId(keyId)
                .keySecretHash(rawSecret)
                .environment(request.environment())
                .build();
        key = apiKeyRepository.save(key);
        return new ApiKeyCreateResponse(key.getId(), key.getKeyId(), rawSecret, request.environment());
    }

    @Override
    public List<ApiKeyResponse> listByMerchant(UUID merchantId) {
        return apiKeyMapper.toResponseList(apiKeyRepository.findByMerchant_Id(merchantId));
    }

    @Override
    @Transactional
    public void revoke(UUID merchandId, UUID keyId) {
        ApiKey apiKey = apiKeyRepository.findById(keyId).filter(k -> k.getMerchant().getId().equals(merchandId)).orElseThrow(() -> new ResourceNotFoundException("apiKey", keyId));

        apiKey.setEnabled(false);

    }

    @Override
    @Transactional
    public ApiKeyCreateResponse rotate(UUID merchantId, UUID keyId) {
        ApiKey apiKey = apiKeyRepository.findById(keyId).filter(k -> k.getMerchant().getId().equals(merchantId))
                .orElseThrow(() -> new ResourceNotFoundException("apiKey", keyId));

        if(!apiKey.isEnabled()){
            throw new RuntimeException("Cannot rotate a revoked API key");
        }

        String newRawSecret = RandomizerUtil.randomBase64(40);
        apiKey.setPreviousKeySecretHash(apiKey.getKeySecretHash());
        apiKey.setKeySecretHash(newRawSecret);
        apiKey.setRotatedAt(LocalDateTime.now());
        apiKey.setGracePeriodExpiresAt(LocalDateTime.now().plusHours(24));
        apiKey = apiKeyRepository.save(apiKey);
        return new ApiKeyCreateResponse(apiKey.getId(), apiKey.getKeyId() , newRawSecret, apiKey.getEnvironment());
    }
}
