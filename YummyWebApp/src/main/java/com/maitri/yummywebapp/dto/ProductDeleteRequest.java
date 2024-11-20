package com.maitri.yummywebapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductDeleteRequest {
        @NotNull(message = "id should be present")
        @NotEmpty(message = "id should be present")
        @NotBlank(message = "id should be present")
        @JsonProperty("id")
        int id;
}
