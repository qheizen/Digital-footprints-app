package com.footprints.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table("lesson_sections")
public class LessonSection {

    @Id
    @Column("id")
    private Long sectionId;

    @Column("lesson_id")
    private Long lessonId;

    @Column("section_type")
    private String sectionType;

    @Column("order_index")
    private Integer orderIndex;
}