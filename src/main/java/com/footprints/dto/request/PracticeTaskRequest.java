package com.footprints.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record PracticeTaskRequest(
        @NotBlank String question,
        @NotBlank String solution,
        @Positive Integer orderIndex
) {
}
