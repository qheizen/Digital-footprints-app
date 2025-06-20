package com.footprints.dto.request;

import com.fasterxml.jackson.databind.JsonNode;
import jakarta.validation.constraints.NotNull;

public record LectureContentRequest(
        @NotNull JsonNode content
) {}
