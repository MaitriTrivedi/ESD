package com.maitri.yummywebapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerDeleteRequest {
        @NotNull(message = "Email should be present")
        @NotEmpty(message = "Email should be present")
        @NotBlank(message = "Email should be present")
        @JsonProperty("email")
        String email;
}
