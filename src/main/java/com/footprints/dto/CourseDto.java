package com.footprints.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Schema(description = "Course data transfer object")
public class CourseDto {

    @Schema(description = "Unique course ID")
    private UUID courseId;

    @NotBlank(message = "Title cannot be blank")
    @Size(min = 5, max = 120, message = "Title must be 5-120 characters")
    @Schema(description = "Course title", requiredMode = Schema.RequiredMode.REQUIRED)
    private String title;

    @Size(max = 2000)
    @Schema(description = "Detailed course description")
    private String description;

    @Schema(description = "Course price in BYN")
    private double price;

    @Schema(description = "IDs of prerequisite courses")
    private List<UUID> prerequisiteIds;

    @Schema(description = "Course creation timestamp", accessMode = Schema.AccessMode.READ_ONLY)
    private OffsetDateTime createdAt;

    @Schema(description = "Last update timestamp", accessMode = Schema.AccessMode.READ_ONLY)
    private OffsetDateTime updatedAt;

    @Schema(description = "Average rating (0-5)", example = "4.5", accessMode = Schema.AccessMode.READ_ONLY)
    @DecimalMin(value = "0.0")
    @DecimalMax(value = "100.0")
    private Double averageRating;

    @Schema(description = "Course difficulty level", example = "ADVANCED")
    private String difficultyLevel;

    @Schema(description = "Estimated completion time in hours", example = "45")
    private Integer estimatedDuration;
}