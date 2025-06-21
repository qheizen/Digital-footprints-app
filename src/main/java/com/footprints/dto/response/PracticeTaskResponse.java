package com.footprints.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;


@Schema(description = "Практическое задание")
public record PracticeTaskResponse(
        @Schema(description = "ID задания", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
        Long taskId,

        @Schema(description = "Вопрос", example = "Как объявить переменную в Java?", requiredMode = Schema.RequiredMode.REQUIRED)
        String question,

        @Schema(description = "Решение", example = "int number = 10;")
        String solution
) {
}