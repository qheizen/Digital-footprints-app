package com.footprints.dto.request;

import com.footprints.resources.Messages;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;

@Schema(description = "Данные для входа")
public record UserLoginRequest(
        @Schema(description = "Email пользователя", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotBlank(message = Messages.EMAIL_INCORRECT) @Email(message = Messages.EMAIL_INCORRECT)
        String email,

        @Schema(description = "Пароль", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotBlank(message = Messages.PASSWORD_EMPTY)
        String password
) {
}