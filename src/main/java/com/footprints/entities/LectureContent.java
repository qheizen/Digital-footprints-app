package com.footprints.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("lecture_content")
public class LectureContent {

    @Id
    @Column("section_id")
    private Long sectionId;

    @Column("lecture_content")
    private String lectureContent;
}
