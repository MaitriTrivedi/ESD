package com.maitri.yummywebapp.service;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

import com.maitri.yummywebapp.dto.CustomerRequest;
import com.maitri.yummywebapp.dto.LoginRequest;
import com.maitri.yummywebapp.entity.Customer;
import com.maitri.yummywebapp.mapper.LoginMapper;
import com.maitri.yummywebapp.repo.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.maitri.yummywebapp.helper.EncryptionService;
import com.maitri.yummywebapp.helper.JWTHelper;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final CustomerRepo repo;
    private final LoginMapper mapper;
    private final EncryptionService encryptionService;
    private final JWTHelper jwtHelper;

    public String loginUser(LoginRequest request) {
        Customer customer = mapper.toEntity(request);
        // Attempt to find the customer in the database
        Optional<Customer> existingCustomer = repo.findByEmail(customer.getEmail());

        if (existingCustomer.isPresent()) {
            // Check if the password matches
            if(!encryptionService.validates(request.password(), existingCustomer.get().getPassword())) {
                return "Wrong Password or Email";
            }
            else {
                return jwtHelper.generateToken(request.email());
            }
        } else {
            return "User not found";
        }
    }
}