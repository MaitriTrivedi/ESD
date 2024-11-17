package com.maitri.yummywebapp.repo;

import com.maitri.yummywebapp.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductsRepo extends JpaRepository<Products, Long> {
//    Optional<Products> findById(Long  id);
}
