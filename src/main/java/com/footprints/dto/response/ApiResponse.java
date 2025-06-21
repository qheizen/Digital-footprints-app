package com.footprints.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

public record ApiResponse<T>(
        @Schema(description = "Статус операции", example = "success")
        String status,

        @Schema(description = "Код ответа", example = "200")
        int code,

        @Schema(description = "Сообщение", example = "Operation completed successfully")
        String message,

        @Schema(description = "Данные")
        T data
) {
}