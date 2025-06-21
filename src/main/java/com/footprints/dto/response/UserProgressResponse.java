package com.footprints.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;


@Schema(description = "Прогресс пользователя")
public record UserProgressResponse(

        @Schema(description = "userId", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
        Long userId,

        @Schema(description = "ID курса", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
        Long courseId,

        @Schema(description = "Процент завершения", example = "75", requiredMode = Schema.RequiredMode.REQUIRED)
        Integer completionPercentage,

        @Schema(description = "Процент правильных ответов", example = "85")
        Integer correctnessPercentage,

        @Schema(description = "Дата последнего доступа", example = "2023-03-20T14:30:00")
        String lastAccessed
) {
}