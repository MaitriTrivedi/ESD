package com.maitri.yummywebapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public record ProductUpdateRequest (
        @JsonProperty("product_name")
        String productName,

        @JsonProperty("price")
        Float price,

        @JsonProperty("id")
        long id
){
}
