package com.example.razorpay.merchant.service.impl;


import com.example.razorpay.merchant.dto.request.MerchantSignupRequest;
import com.example.razorpay.merchant.dto.response.MerchantResponse;
import com.example.razorpay.merchant.repository.AppUserRepository;
import com.example.razorpay.merchant.repository.MerchantRepository;
import com.example.razorpay.merchant.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {


    private final AppUserRepository appUserRepository;

    private final MerchantRepository merchantRepository;

    @Override
    public MerchantResponse signup(MerchantSignupRequest request) {
        if(merchantRepository.existsByEmail(request.email())){
            throw new RuntimeException("Merchant with email already exists: " + request.email());
        }
        return null;
    }
}
