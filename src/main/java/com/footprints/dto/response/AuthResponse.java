package com.footprints.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Ответ аутентификации")
public record AuthResponse(
        @Schema(description = "JWT токен", example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...")
        String token,

        @Schema(description = "Тип токена", example = "Bearer")
        String tokenType,

        @Schema(description = "Данные пользователя")
        UserResponse user
) {
}