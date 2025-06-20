package com.footprints.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Данные курса")
public record CourseResponse(
        @Schema(description = "ID курса", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
        Long id,

        @Schema(description = "Название курса", example = "Java Fundamentals", requiredMode = Schema.RequiredMode.REQUIRED)
        String title,

        @Schema(description = "Описание курса", example = "Основы программирования на Java")
        String description,

        @Schema(description = "Ключевое слово", example = "Java")
        String keyWord,

        @Schema(description = "Уровень сложности (1-20)", example = "3", requiredMode = Schema.RequiredMode.REQUIRED)
        Integer difficultyLevel,

        @Schema(description = "Дата создания", example = "2023-01-10T08:00:00")
        String createdAt
) {}