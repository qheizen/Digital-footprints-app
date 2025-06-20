package com.footprints.dto.request;

import com.footprints.resources.Messages;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "Регистрация пользователя")
public record UserRegisterRequest(
        @Schema(description = "Email пользователя", requiredMode = Schema.RequiredMode.REQUIRED)
        @Email(message = Messages.EMAIL_INCORRECT)
        String email,

        @Schema(description = "Пароль", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotBlank(message = Messages.PASSWORD_EMPTY)
        String password,

        @Schema(description = "Ник пользователя", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotBlank(message = Messages.USERNAME_EMPTY)
        String username
) {}