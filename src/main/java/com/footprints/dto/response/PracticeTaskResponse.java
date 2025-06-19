package com.footprints.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

@Schema(description = "Практическое задание")
public record PracticeTaskResponse(
        @Schema(description = "ID задания", example = "1", requiredMode = REQUIRED)
        Long taskId,

        @Schema(description = "Вопрос", example = "Как объявить переменную в Java?", requiredMode = REQUIRED)
        String question,

        @Schema(description = "Решение", example = "int number = 10;")
        String solution
) {}