package com.maitri.yummywebapp.mapper;

import com.maitri.yummywebapp.dto.CustomerDeleteRequest;
import com.maitri.yummywebapp.entity.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerDeleteMapper {
    public Customer toEntity(CustomerDeleteRequest request) {
        return Customer.builder()
                .email(request.getEmail())
                .build();
    }
}
