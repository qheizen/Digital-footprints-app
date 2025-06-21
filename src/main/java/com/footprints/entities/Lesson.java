package com.footprints.entities;

import lombok.*;
import org.springframework.data.annotation.*;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table("lessons")
public class Lesson {

    @Id
    @Column("id")
    private Long lessonId;

    @Column("course_id")
    private Long courseId;

    @Column("title")
    private String title;

    @Column("order_index")
    private Integer orderIndex;

    @CreatedDate
    @Column("created_at")
    private LocalDateTime createdAt;
}