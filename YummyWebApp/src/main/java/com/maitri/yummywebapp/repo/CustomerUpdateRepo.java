package com.maitri.yummywebapp.repo;

import com.maitri.yummywebapp.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerUpdateRepo extends JpaRepository<Customer, Long> {
    Optional<Customer> findByEmail(String email);
}
