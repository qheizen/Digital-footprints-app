package com.footprints.dto.request;

import jakarta.validation.constraints.NotNull;

public record SectionStatusRequest(
        @NotNull Long userId,
        @NotNull Long sectionId,
        @NotNull Boolean isCompleted
) {}