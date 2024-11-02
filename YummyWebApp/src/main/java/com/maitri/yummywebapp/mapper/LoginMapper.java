package com.maitri.yummywebapp.mapper;

import com.maitri.yummywebapp.dto.LoginRequest;
import com.maitri.yummywebapp.entity.Customer;
import org.springframework.stereotype.Service;

@Service
public class LoginMapper {
    public Customer toEntity(LoginRequest request) {
        return Customer.builder()
                .email(request.email())
                .password(request.password())
                .build();
    }
}
