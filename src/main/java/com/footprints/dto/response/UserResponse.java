package com.footprints.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

@Schema(description = "Данные пользователя")
public record UserResponse(
        @Schema(description = "ID пользователя", example = "1", requiredMode = REQUIRED)
        Long id,

        @Schema(description = "Имя пользователя", example = "john_doe", requiredMode = REQUIRED)
        String username,

        @Schema(description = "Email", example = "john@example.com", requiredMode = REQUIRED)
        String email,

        @Schema(description = "Роль пользователя", example = "STUDENT", requiredMode = REQUIRED)
        String role,

        @Schema(description = "Дата регистрации", example = "2023-01-15T10:30:00")
        String createdAt
) {
}