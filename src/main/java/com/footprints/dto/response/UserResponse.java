package com.footprints.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;


@Schema(description = "Данные пользователя")
public record UserResponse(
        @Schema(description = "ID пользователя", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
        Long id,

        @Schema(description = "Имя пользователя", example = "john_doe", requiredMode = Schema.RequiredMode.REQUIRED)
        String username,

        @Schema(description = "Email", example = "john@example.com", requiredMode = Schema.RequiredMode.REQUIRED)
        String email,

        @Schema(description = "Роль пользователя", example = "STUDENT", requiredMode = Schema.RequiredMode.REQUIRED)
        String role,

        @Schema(description = "Дата регистрации", example = "2023-01-15T10:30:00")
        String createdAt
) {
}