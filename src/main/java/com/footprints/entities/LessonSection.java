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
@Table("lesson_sections")
public class LessonSection {

    @Id
    @Column("ls_id")
    private Long id;

    @Column("ls_lesson_id")
    private Long lessonId;

    @Column("ls_section_type")
    private String sectionType;

    @Column("ls_order_index")
    private Integer orderIndex;

}
