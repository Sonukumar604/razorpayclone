package com.example.razorpay.payment.mapper;

import com.example.razorpay.payment.dto.response.OrderResponse;
import com.example.razorpay.payment.entity.OrderRecord;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderMapper {

    OrderResponse toResponse(OrderRecord orderRecord);

}
