package com.footprints.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;

public record ProgressUpdateRequest (
        @Min(0) @Max(100) Integer completionPercentage,
        @Min(0) @Max(100) Integer correctnessPercentage
){
}
