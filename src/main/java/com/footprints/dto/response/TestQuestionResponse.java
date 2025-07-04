package com.footprints.dto.response;

import com.fasterxml.jackson.databind.JsonNode;
import io.swagger.v3.oas.annotations.media.Schema;


@Schema(description = "Тестовый вопрос")
public record TestQuestionResponse(
        @Schema(description = "ID вопроса", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
        Long id,

        @Schema(description = "Вопрос", example = "Что такое полиморфизм?", requiredMode = Schema.RequiredMode.REQUIRED)
        String question,

        @Schema(description = "Варианты ответов", example = "[\"Наследование\", \"Инкапсуляция\", \"Перегрузка методов\"]")
        JsonNode options,

        @Schema(description = "Правильный ответ", example = "Перегрузка методов")
        String correctAnswer
) {
}