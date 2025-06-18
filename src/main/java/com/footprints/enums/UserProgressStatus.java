package com.footprints.enums;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(enumAsRef = true)
public enum UserProgressStatus {
    @Schema(description = "Content untouched")
    UNTOUCHED,

    @Schema(description = "Course percentage on low level")
    STARTED,

    @Schema(description = "Course percentage on middle level")
    IN_PROGRESS,

    @Schema(description = "Course done")
    FINISHED
}