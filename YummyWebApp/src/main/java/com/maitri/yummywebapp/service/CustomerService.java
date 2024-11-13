package com.maitri.yummywebapp.service;

import java.util.Optional;

import java.lang.reflect.Field;
import com.maitri.yummywebapp.dto.CustomerUpdateRequest;
import com.maitri.yummywebapp.dto.CustomerRequest;
import com.maitri.yummywebapp.dto.CustomerResponse;
import com.maitri.yummywebapp.entity.Customer;
import com.maitri.yummywebapp.mapper.CustomerMapper;
import com.maitri.yummywebapp.mapper.CustomerUpdateMapper;
import com.maitri.yummywebapp.repo.CustomerUpdateRepo;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.maitri.yummywebapp.helper.EncryptionService;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class CustomerService {
    // To store entity into sql database
    private final CustomerUpdateRepo repo;

    // To convert dto to entity
    private final CustomerUpdateMapper updateMapper;
    private final CustomerMapper createMapper;

    private final EncryptionService encryptionService;

    public Customer createCustomer(CustomerRequest request) {
        System.out.println("==================== create service");

        // This will convert our dto to entity using Mapper
        Customer customer = createMapper.toEntity(request);
        customer.setPassword(encryptionService.encode(customer.getPassword()));
        // Stores entity into database using Repo
        repo.save(customer);
        return customer;
    }

    public Customer updateCustomer(CustomerUpdateRequest request) {
        System.out.println("==================== update service");

        // Retrieve the existing customer from the database
        Optional<Customer> existingCustomerOpt = repo.findByEmail(request.getEmail());

        if (existingCustomerOpt.isEmpty()) {
            throw new RuntimeException("Customer not found with email: " + request.getEmail());
        }

        Customer existingCustomer = existingCustomerOpt.get();

        // Convert the DTO to an entity using Mapper
        Customer updatedCustomer = updateMapper.toEntity(request);

        // Compare each field dynamically and update only the changed fields
        Field[] fields = Customer.class.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object oldValue = field.get(existingCustomer);
                Object newValue = field.get(updatedCustomer);

                if (newValue != null && (oldValue == null || !newValue.equals(oldValue))) {
                    System.out.println(field.getName() + " changed from " + oldValue + " to " + newValue);
                    field.set(existingCustomer, newValue); // Update the field in the existing customer
                }
            } catch (IllegalAccessException e) {
                System.err.println("Error accessing field: " + field.getName());
            }
        }

        // Save the updated entity
        repo.save(existingCustomer);
        return existingCustomer;
    }
}