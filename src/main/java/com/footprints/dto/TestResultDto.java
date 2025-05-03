package com.footprints.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@Schema(description = "Результат теста")
public class TestResultDto {
    @Schema(description = "ID теста")
    private UUID testId;

    @Schema(description = "Набранные баллы", example = "85")
    private Integer score;

    @Schema(description = "Время завершения")
    private OffsetDateTime completedAt;
}