package com.maitri.yummywebapp.mapper;

import com.maitri.yummywebapp.dto.CustomerRequest;
import com.maitri.yummywebapp.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {
    public Customer toEntity(CustomerRequest request) {
        return Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())

                .email(request.email())
                .password(request.password())
                .build();
    }
}
