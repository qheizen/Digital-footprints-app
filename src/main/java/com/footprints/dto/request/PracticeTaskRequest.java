package com.footprints.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.NotNull;

public record PracticeTaskRequest(
        @NotNull Long sectionId,
        @NotBlank String question,
        @NotBlank String solution,
        @NotNull @Positive Integer orderIndex
) {
}
