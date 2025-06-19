package com.footprints.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record LessonSectionRequest(
        @NotNull Long lessonId,
        @NotBlank String sectionType,
        @Positive Integer orderIndex
) { }
