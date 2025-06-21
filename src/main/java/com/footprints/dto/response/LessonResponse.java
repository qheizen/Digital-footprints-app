package com.footprints.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;


@Schema(description = "Данные урока")
public record LessonResponse(
        @Schema(description = "ID урока", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
        Long id,

        @Schema(description = "ID курса", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
        Long courseId,

        @Schema(description = "Название урока", example = "Введение в ООП", requiredMode = Schema.RequiredMode.REQUIRED)
        String title,

        @Schema(description = "Порядковый номер", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
        Integer orderIndex,

        @Schema(description = "Количество секций", example = "3")
        Integer sectionCount
) {
}