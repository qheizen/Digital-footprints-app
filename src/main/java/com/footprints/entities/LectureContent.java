package com.footprints.entities;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table("lecture_contents")
public class LectureContent {

    @Id
    @Column("section_id")
    private Long sectionId;

    @Column("content")
    private JsonNode content;
}