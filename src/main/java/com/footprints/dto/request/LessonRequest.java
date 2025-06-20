package com.footprints.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record LessonRequest(
        @NotNull Long courseId,
        @NotBlank String title,
        @NotNull @Positive Integer orderIndex
) {}

