package com.footprints.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Authentication response containing access token")
public class AuthResponse {

    @Schema(description = "JWT access token for authenticated requests", requiredMode = Schema.RequiredMode.REQUIRED)
    private String accessToken;

    @Schema(description = "Type of the access token")
    private String tokenType = "Bearer";

    @Schema(description = "Expiration time of the access token in seconds")
    private long expiresIn;
}