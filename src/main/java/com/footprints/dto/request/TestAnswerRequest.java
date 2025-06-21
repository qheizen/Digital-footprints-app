package com.footprints.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;

public record TestAnswerRequest(
        @NotNull Long userId,
        @NotNull Long questionId,
        @NotBlank String answer
) {
}
