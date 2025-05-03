package com.footprints.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.util.UUID;

@Data
@Schema(description = "DTO пользователя")
public class UserDto {
    @Schema(description = "ID пользователя", accessMode = Schema.AccessMode.READ_ONLY)
    private UUID userId;

    @Schema(description = "Логин")
    private String username;

    @Schema(description = "Уровень навыка")
    private Integer skillLevel;
}