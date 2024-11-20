package com.maitri.yummywebapp.controller;

import com.maitri.yummywebapp.dto.CustomerDeleteRequest;
import com.maitri.yummywebapp.dto.CustomerUpdateRequest;
import com.maitri.yummywebapp.dto.ProductUpdateRequest;
import com.maitri.yummywebapp.dto.ProductsRequest;
import com.maitri.yummywebapp.entity.Customer;
import com.maitri.yummywebapp.entity.Products;
import com.maitri.yummywebapp.service.ProductsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/products")
public class ProductsController {

    // final : it will create only one object in whole project container, when we run the project
    private final ProductsService productsService;

    @PostMapping ("/add")// for post request
    public ResponseEntity<Products> addProduct(@RequestBody @Valid ProductsRequest request) {
        System.out.println("==================== create controller");
        return ResponseEntity.ok(productsService.addProduct(request));
    }

    @PutMapping("/update") // for post request
    public ResponseEntity<Products> Product(@RequestBody @Valid ProductUpdateRequest request) {
        System.out.println("==================== update controller");
        return ResponseEntity.ok(productsService.updateProduct(request));
    }

    @DeleteMapping("/remove_product/{id}") // for post request
    public ResponseEntity<String> Product(@PathVariable(required = false) Long id) {
        System.out.println("==================== delete controller");
        return ResponseEntity.ok(productsService.deleteProduct(id));
    }

    @GetMapping({"/get", "/get/{id}"})
    public ResponseEntity<?> getProducts(@PathVariable(required = false) Long id) {
        if (id != null) {
            // If an ID is provided, fetch and return the specific product
            Products product = productsService.getProductById(id);
            if (product != null) {
                return ResponseEntity.ok(product);
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            // If no ID is provided, fetch and return all products
            List<Products> allProducts = productsService.getAllProducts();
            return ResponseEntity.ok(allProducts);
        }
    }

    @GetMapping({"/get_top_2"})
    public List<Products> getTop2Products(@RequestParam double minPrice, @RequestParam double maxPrice) {
        return productsService.getTop2ProductsInPriceRange(minPrice, maxPrice);
    }
}