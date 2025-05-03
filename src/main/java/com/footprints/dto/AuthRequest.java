package com.footprints.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(description = "Authentication request DTO")
public class AuthRequest {

    @NotBlank(message = "Username must not be empty")
    @Size(min = 3, max = 50, message = "Username must be 3-50 characters")
    @Schema(description = "Unique user identifier", example = "john_doe123", requiredMode = Schema.RequiredMode.REQUIRED)
    private String username;

    @NotBlank(message = "Password must not be empty")
    @Size(min = 8, max = 100, message = "Password must be 8-100 characters")
    @Schema(description = "User password", example = "SecurePass123!", requiredMode = Schema.RequiredMode.REQUIRED)
    private String password;
}