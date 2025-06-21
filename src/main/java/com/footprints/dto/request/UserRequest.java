package com.footprints.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;


@Schema(description = "Данные пользователя для создания/обновления")
public record UserRequest(
        @Schema(description = "Имя пользователя", examples = "Sasha", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotBlank @Size(max = 100)
        String username,

        @Schema(description = "Email пользователя", requiredMode = Schema.RequiredMode.REQUIRED)
        @Email(message = "Некорректный email")
        @NotBlank
        String userEmail,

        @Schema(description = "Пароль пользователя")
        @NotBlank @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d).{8,}$", message = "Weak password")
        String userPassword
) {
}
