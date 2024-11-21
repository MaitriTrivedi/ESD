package com.maitri.yummywebapp.service;

import com.maitri.yummywebapp.dto.*;
import com.maitri.yummywebapp.dto.CustomerUpdateRequest;
import com.maitri.yummywebapp.entity.Customer;
import com.maitri.yummywebapp.entity.Products;
import com.maitri.yummywebapp.helper.EncryptionService;
import com.maitri.yummywebapp.mapper.ProductsMapper;
import com.maitri.yummywebapp.mapper.ProductsUpdateMapper;
import com.maitri.yummywebapp.repo.ProductsRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;


@Service
@RequiredArgsConstructor
public class ProductsService {

//    // To store entity into sql database
//    private final ProductsRepo repo;

    @Autowired
    ProductsRepo repo;

    // To convert dto to entity
    private final ProductsMapper mapper;
    private final ProductsUpdateMapper updatemapper;
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

    public String deleteProduct(Long id) {
        System.out.println("==================== delete service");

        Optional<Products> existingProductsOpt = repo.findById(id);

        if (existingProductsOpt.isEmpty()) {
            throw new RuntimeException("Product not found with email: " + id);
        }

        Products existingProduct = existingProductsOpt.get();

        // deletes entity into database using Repo
        repo.delete(existingProduct);
        return "Deleted Successfully.";
    }

    public Products updateProduct(ProductUpdateRequest request) {
        System.out.println("==================== update service" + request);

        // Retrieve the existing product from the database
        Optional<Products> existingProductOpt = repo.findById(request.id());

        if (existingProductOpt.isEmpty()) {
            throw new RuntimeException("Product not found with id: " + request.id());
        }

        Products existingProduct = existingProductOpt.get();

        // Map the request to a new entity
        Products updatedProduct = updatemapper.toEntity(request);

        // Update fields only if they are not null
        if (updatedProduct.getProductName() != null) {
            existingProduct.setProductName(updatedProduct.getProductName());
        }
        if (updatedProduct.getPrice() != null) {
            existingProduct.setPrice(updatedProduct.getPrice());
        }

        // Save the updated entity
        repo.save(existingProduct);
        return existingProduct;
    }



    public List<Products> getTop2ProductsInPriceRange(double minPrice, double maxPrice) {
        Pageable pageable = PageRequest.of(0, 2);
        return repo.findTop2ProductsInPriceRange(minPrice, maxPrice, pageable);
    }
}
