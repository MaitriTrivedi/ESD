package com.maitri.yummywebapp.service;

import java.util.Optional;

import com.maitri.yummywebapp.dto.CustomerRequest;
import com.maitri.yummywebapp.dto.CustomerResponse;
import com.maitri.yummywebapp.entity.Customer;
import com.maitri.yummywebapp.mapper.CustomerMapper;
import com.maitri.yummywebapp.repo.CustomerRepo;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class CustomerService {

    // To store entity into sql database
    private final CustomerRepo repo;

    // To convert dto to entity
    private final CustomerMapper mapper;

    public Customer createCustomer(CustomerRequest request) {
        System.out.println("==================== create service");

        // This will convert our dto to entity using Mapper
        Customer customer = mapper.toEntity(request);

        // Stores entity into database using Repo
        repo.save(customer);
        return customer;
    }
}
