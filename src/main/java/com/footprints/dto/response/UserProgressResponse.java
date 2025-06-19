package com.footprints.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

@Schema(description = "Прогресс пользователя")
public record UserProgressResponse(
        @Schema(description = "ID курса", example = "1", requiredMode = REQUIRED)
        Long courseId,

        @Schema(description = "Процент завершения", example = "75", requiredMode = REQUIRED)
        Integer completionPercentage,

        @Schema(description = "Процент правильных ответов", example = "85")
        Integer correctnessPercentage,

        @Schema(description = "Дата последнего доступа", example = "2023-03-20T14:30:00")
        String lastAccessed
) {}