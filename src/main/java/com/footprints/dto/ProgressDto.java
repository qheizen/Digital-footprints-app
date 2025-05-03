package com.footprints.dto;

import com.footprints.entities.CompletionStatus;
import com.footprints.entities.LessonProgress;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@Schema(description = "DTO для отслеживания прогресса урока")
public class ProgressDto {

    @Schema(description = "ID записи прогресса", accessMode = Schema.AccessMode.READ_ONLY)
    private UUID progressId;

    @Schema(description = "ID урока", requiredMode = Schema.RequiredMode.REQUIRED)
    private UUID lessonId;

    @Schema(description = "Статус завершения", requiredMode = Schema.RequiredMode.REQUIRED)
    private CompletionStatus completionStatus;

    @Schema(description = "Оценка за тест")
    private Integer testScore;

    @Schema(description = "Время последнего обновления", accessMode = Schema.AccessMode.READ_ONLY)
    private OffsetDateTime lastUpdated;

    public static ProgressDto fromEntity(LessonProgress progress) {
        ProgressDto dto = new ProgressDto();
        dto.setProgressId(progress.getProgressId());
        dto.setLessonId(progress.getLesson().getLessonId());
        dto.setCompletionStatus(progress.getCompletionStatus());
        dto.setTestScore(progress.getTestScore());
        dto.setLastUpdated(progress.getLastUpdated());
        return dto;
    }
}