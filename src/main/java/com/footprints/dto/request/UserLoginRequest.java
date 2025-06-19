package com.footprints.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "Данные для входа")
public record UserLoginRequest(
        @Schema(description = "Email пользователя", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotBlank(message = "Email не может быть пустым")
        String email,

        @Schema(description = "Пароль", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotBlank(message = "Password не может быть пустым")
        String password
) {
}