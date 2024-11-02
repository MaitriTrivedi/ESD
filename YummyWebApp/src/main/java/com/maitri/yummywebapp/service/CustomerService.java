package com.maitri.yummywebapp.service;

import java.util.Optional;

import com.maitri.yummywebapp.dto.CustomerRequest;
import com.maitri.yummywebapp.dto.CustomerResponse;
import com.maitri.yummywebapp.entity.Customer;
import com.maitri.yummywebapp.mapper.CustomerMapper;
import com.maitri.yummywebapp.repo.CustomerRepo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepo repo;
    private final CustomerMapper mapper;
    public String createCustomer(CustomerRequest request) {
        Customer customer = mapper.toEntity(request);
        repo.save(customer);
        return "Created";
    }
}
