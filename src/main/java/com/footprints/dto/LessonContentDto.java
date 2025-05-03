package com.footprints.dto;

import com.footprints.entities.LectureContent;
import com.footprints.entities.PracticalContent;
import com.footprints.entities.TestContent;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.util.UUID;

@Data
@Schema(description = "Контент урока")
public class LessonContentDto {
    @Schema(description = "ID лекции")
    private UUID lectureId;

    @Schema(description = "ID практического задания")
    private UUID practicalId;

    @Schema(description = "ID теста")
    private UUID testId;

    @Schema(description = "Текст лекции")
    private String lectureText;

    @Schema(description = "Описание практики")
    private String practicalDescription;
}