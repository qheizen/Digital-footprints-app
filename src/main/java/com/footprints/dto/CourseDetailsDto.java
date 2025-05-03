package com.footprints.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.util.List;
import java.util.UUID;

@Data
@Schema(description = "Детали курса")
public class CourseDetailsDto {
    @Schema(description = "ID курса")
    private UUID courseId;

    @Schema(description = "Название курса", example = "Java Basics")
    private String title;

    @Schema(description = "Список ID уроков")
    private List<UUID> lessonIds;

    @Schema(description = "Средний рейтинг", example = "4.7")
    private Double averageRating;
}