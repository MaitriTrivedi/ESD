package com.maitri.yummywebapp.mapper;

import com.maitri.yummywebapp.dto.CustomerUpdateRequest;
import com.maitri.yummywebapp.entity.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerUpdateMapper {
    public Customer toEntity(CustomerUpdateRequest request) {
        return Customer.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())

                .email(request.getEmail())
                .password(request.getPassword())
                .build();
    }
}
