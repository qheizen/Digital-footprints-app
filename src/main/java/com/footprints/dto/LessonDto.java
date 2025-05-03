package com.footprints.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@Schema(description = "Lesson data transfer object")
public class LessonDto {

    @Schema(description = "Unique lesson ID", accessMode = Schema.AccessMode.READ_ONLY)
    private UUID lessonId;

    @NotNull(message = "Course ID cannot be null")
    @Schema(description = "Parent course ID", requiredMode = Schema.RequiredMode.REQUIRED)
    private UUID courseId;

    @Min(value = 0, message = "Lesson order cannot be negative")
    @Schema(description = "Position in course sequence", requiredMode = Schema.RequiredMode.REQUIRED)
    private int lessonOrder;

    @Schema(description = "Associated lecture content ID", accessMode = Schema.AccessMode.READ_ONLY)
    private UUID lectureId;

    @Schema(description = "Associated practical content ID", accessMode = Schema.AccessMode.READ_ONLY)
    private UUID practicalId;

    @Schema(description = "Associated test content ID", accessMode = Schema.AccessMode.READ_ONLY)
    private UUID testId;

    @Schema(description = "Lesson creation timestamp", accessMode = Schema.AccessMode.READ_ONLY)
    private OffsetDateTime createdAt;

    @Schema(description = "Last update timestamp", accessMode = Schema.AccessMode.READ_ONLY)
    private OffsetDateTime updatedAt;

    @Schema(description = "Lesson completion status", accessMode = Schema.AccessMode.READ_ONLY)
    private String completionStatus;

    @Schema(description = "Number of completed tasks", accessMode = Schema.AccessMode.READ_ONLY)
    private Integer completedTasks;
}