package com.maitri.yummywebapp.service;

import com.maitri.yummywebapp.dto.CustomerRequest;
import com.maitri.yummywebapp.dto.ProductsRequest;
import com.maitri.yummywebapp.entity.Customer;
import com.maitri.yummywebapp.entity.Products;
import com.maitri.yummywebapp.helper.EncryptionService;
import com.maitri.yummywebapp.mapper.ProductsMapper;
import com.maitri.yummywebapp.repo.ProductsRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductsService {

//    // To store entity into sql database
//    private final ProductsRepo repo;

    @Autowired
    ProductsRepo repo;

    // To convert dto to entity
    private final ProductsMapper mapper;
    private final EncryptionService encryptionService;

    public Products addProduct(ProductsRequest request) {
        System.out.println("==================== create service");

        // This will convert our dto to entity using Mapper
        Products product = mapper.toEntity(request);
        repo.save(product);
        return product;
    }

    public Products getProductById(Long id) {
        System.out.println("==================== getProductById service");
        // return repo.findById(id).orElse(null); // Returns the product or null if not found
        System.out.println("==================== JPA REPO getProductById service");
        return repo.findById(id).orElse(null);
    }

    public List<Products> getAllProducts() {
        System.out.println("==================== getAllProducts service");
        // return repo.findAll(); // Returns all products
        return repo.findAll();
    }
}
