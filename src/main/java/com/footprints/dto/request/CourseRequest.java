package com.footprints.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;


public record CourseRequest(
        @NotBlank
        String title,
        String description,
        String keyWord,

        @Min(1)
        @Max(20)
        @NotNull
        Integer difficultyLevel
) {
}