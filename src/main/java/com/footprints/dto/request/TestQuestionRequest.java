package com.footprints.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import com.fasterxml.jackson.databind.JsonNode;

public record TestQuestionRequest(
        @NotNull Long sectionId,
        @NotBlank String question,
        @NotNull JsonNode options,
        @NotBlank String correctAnswer,
        @NotNull @Positive Integer orderIndex
) {
}
