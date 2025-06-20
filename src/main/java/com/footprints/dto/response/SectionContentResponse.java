package com.footprints.dto.response;

import com.fasterxml.jackson.databind.JsonNode;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;


@Schema(description = "Содержимое секции урока")
public record SectionContentResponse(
        @Schema(description = "ID секции", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
        Long sectionId,

        @Schema(description = "Тип секции", example = "LECTURE", requiredMode = Schema.RequiredMode.REQUIRED)
        String sectionType,

        @Schema(description = "Содержимое (для лекций)")
        JsonNode content,

        @Schema(description = "Практические задания")
        List<PracticeTaskResponse> practiceTasks,

        @Schema(description = "Тестовые вопросы")
        List<TestQuestionResponse> testQuestions
) {}