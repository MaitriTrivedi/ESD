//package com.maitri.yummywebapp.controller;
//
//import com.maitri.yummywebapp.dto.ProductsRequest;
//import com.maitri.yummywebapp.entity.Products;
//import com.maitri.yummywebapp.service.ProductsService;
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RequiredArgsConstructor
//@RestController
//@RequestMapping("/api/v1/products")
//public class ProductsController {
//
//    // final : it will create only one object in whole project container, when we run the project
//    private final ProductsService productsService;
//
//    @PostMapping // for post request
//    public ResponseEntity<Products> addProduct(@RequestBody @Valid ProductsRequest request) {
//        System.out.println("==================== create controller");
//        return ResponseEntity.ok(productsService.addProduct(request));
//    }
//
//    @GetMapping // for post request
//    public ResponseEntity<Products> getProducts(@RequestBody @Valid ProductsRequest request) {
//        System.out.println("==================== create controller");
//        return ResponseEntity.ok(productsService.addProduct(request));
//    }
//}