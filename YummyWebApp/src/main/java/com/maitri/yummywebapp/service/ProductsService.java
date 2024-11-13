//package com.maitri.yummywebapp.service;
//
//import com.maitri.yummywebapp.dto.CustomerRequest;
//import com.maitri.yummywebapp.dto.ProductsRequest;
//import com.maitri.yummywebapp.entity.Customer;
//import com.maitri.yummywebapp.entity.Products;
//import com.maitri.yummywebapp.helper.EncryptionService;
//import com.maitri.yummywebapp.mapper.ProductsMapper;
//import com.maitri.yummywebapp.repo.ProductsRepo;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class ProductsService {
//
//    // To store entity into sql database
//    private final ProductsRepo repo;
//
//    // To convert dto to entity
//    private final ProductsMapper mapper;
//    private final EncryptionService encryptionService;
//
//    public Products addProduct(ProductsRequest request) {
//        System.out.println("==================== create service");
//
//        // This will convert our dto to entity using Mapper
//        Products product = mapper.toEntity(request);
//        repo.save(product);
//        return product;
//    }
//}
