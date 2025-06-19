package com.footprints.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

@Schema(description = "Данные курса")
public record CourseResponse(
        @Schema(description = "ID курса", example = "1", requiredMode = REQUIRED)
        Long id,

        @Schema(description = "Название курса", example = "Java Fundamentals", requiredMode = REQUIRED)
        String title,

        @Schema(description = "Описание курса", example = "Основы программирования на Java")
        String description,

        @Schema(description = "Уровень сложности (1-5)", example = "3", requiredMode = REQUIRED)
        Integer difficultyLevel,

        @Schema(description = "Дата создания", example = "2023-01-10T08:00:00")
        String createdAt
) {
}