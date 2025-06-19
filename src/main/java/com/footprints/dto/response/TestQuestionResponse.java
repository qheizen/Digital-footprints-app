package com.footprints.dto.response;

import com.fasterxml.jackson.databind.JsonNode;
import io.swagger.v3.oas.annotations.media.Schema;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

@Schema(description = "Тестовый вопрос")
public record TestQuestionResponse(
        @Schema(description = "ID вопроса", example = "1", requiredMode = REQUIRED)
        Long id,

        @Schema(description = "Вопрос", example = "Что такое полиморфизм?", requiredMode = REQUIRED)
        String question,

        @Schema(description = "Варианты ответов", example = "[\"Наследование\", \"Инкапсуляция\", \"Перегрузка методов\"]")
        JsonNode options,

        @Schema(description = "Правильный ответ", example = "Перегрузка методов")
        String correctAnswer
) {}