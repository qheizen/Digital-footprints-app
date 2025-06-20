package com.footprints.entities;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import jakarta.persistence.Entity;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("lesson_sections")
public class LessonSection {

    @Id
    @Column("id")
    private Long sectionId;

    @NotNull(message = "Lesson ID is required")
    @Column("lesson_id")
    private Long lessonId;

    @NotNull(message = "Section type is required")
    @Column("section_type")
    private String sectionType;

    @NotNull(message = "Order index is required")
    @Column("order_index")
    private Integer orderIndex;
}