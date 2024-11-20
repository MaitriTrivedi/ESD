package com.maitri.yummywebapp.repo;

import com.maitri.yummywebapp.entity.Customer;
import com.maitri.yummywebapp.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductUpdateRepo extends JpaRepository<Products, Long> {
    Optional<Products> findById(long id);
}
