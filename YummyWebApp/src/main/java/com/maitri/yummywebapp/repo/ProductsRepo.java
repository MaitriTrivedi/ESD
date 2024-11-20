package com.maitri.yummywebapp.repo;

import com.maitri.yummywebapp.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import com.maitri.yummywebapp.entity.Products;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@Repository
public interface ProductsRepo extends JpaRepository<Products, Long> {
    @Query("SELECT p FROM Products p WHERE p.price BETWEEN :minPrice AND :maxPrice ORDER BY p.price ASC")
    List<Products> findTop2ProductsInPriceRange(@Param("minPrice") double minPrice, @Param("maxPrice") double maxPrice, Pageable pageable);

    Optional<Products> findById(Long id);
}
