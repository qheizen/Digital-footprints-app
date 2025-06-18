package com.footprints.entities;

import com.fasterxml.jackson.databind.JsonNode;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("lecture_contents")
public class LectureContent {

    @Id
    @NotNull(message = "Section ID is required")
    @Column("section_id")
    private Long sectionId;

    @NotNull(message = "Content is required")
    @Column("content")
    private JsonNode content;
}