package com.footprints.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

public record JwtAuthResponse(
        @Schema(description = "JWT токен", example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...")
        String accessToken,

        @Schema(description = "Тип токена", example = "Bearer")
        String tokenType
) {
    private static final String BEARER = "Bearer";

    public JwtAuthResponse(String accessToken) {
        this(accessToken, BEARER);
    }
}