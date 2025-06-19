package com.footprints.dto.response;

import com.fasterxml.jackson.databind.JsonNode;
import io.swagger.v3.oas.annotations.media.Schema;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

@Schema(description = "Содержимое секции урока")
public record SectionContentResponse(
        @Schema(description = "ID секции", example = "1", requiredMode = REQUIRED)
        Long sectionId,

        @Schema(description = "Тип секции", example = "LECTURE", requiredMode = REQUIRED)
        String sectionType,

        @Schema(description = "Содержимое (для лекций)")
        JsonNode content,

        @Schema(description = "Практические задания")
        List<PracticeTaskResponse> practiceTasks,

        @Schema(description = "Тестовые вопросы")
        List<TestQuestionResponse> testQuestions
) {}