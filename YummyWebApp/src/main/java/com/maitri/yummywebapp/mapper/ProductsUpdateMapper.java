package com.maitri.yummywebapp.mapper;

import com.maitri.yummywebapp.dto.ProductUpdateRequest;
import com.maitri.yummywebapp.entity.Products;
import org.springframework.stereotype.Service;

@Service
public class ProductsUpdateMapper {
    public Products toEntity(ProductUpdateRequest request) {
        return Products.builder()
                .productName(request.productName())
                .price(request.price())
                .build();
    }
}
