package com.footprints.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;

public record ProgressUpdateRequest(
        @NotNull Long userId,
        @NotNull Long courseId,
        @NotNull @Min(0) @Max(100) Integer completionPercentage,
        @NotNull @Min(0) @Max(100) Integer correctnessPercentage
) {}
