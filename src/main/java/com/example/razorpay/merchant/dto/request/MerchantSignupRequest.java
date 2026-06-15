package com.example.razorpay.merchant.dto.request;

import com.example.razorpay.common.enums.BusinessType;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.NonNull;

public record MerchantSignupRequest(

        @NotNull(message = "Name cannot be null")
        @Size(max = 50, message = "Name should not be more than 50 characters long")
        String name,

        @Email
        @NotNull(message = "Email is required")
        String email,

        @NotNull(message = "Password is required")
        @Size(min = 0, message = "Password should be at least 8 characters long")
        String password,

        @Size(max = 50, message = "Businessname should not be more than 50 characters long")
        String businessName,


        BusinessType businessType

) {
}
