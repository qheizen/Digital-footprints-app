package com.footprints.dto.request;

import jakarta.validation.constraints.NotNull;

public record SectionStatusRequest(
        @NotNull Boolean isCompleted
) {
}
