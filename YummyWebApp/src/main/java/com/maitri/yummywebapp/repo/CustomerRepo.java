package com.maitri.yummywebapp.repo;
import java.util.Optional;

import com.maitri.yummywebapp.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Long> {
    Optional<Customer> findByEmail(String email);
}