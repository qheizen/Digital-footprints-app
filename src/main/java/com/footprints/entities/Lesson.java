package com.footprints.entities;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.*;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("lessons")
public class Lesson {

    @Id
    @Column("id")
    private Long lessonId;

    @NotNull(message = "Course ID is required")
    @Column("course_id")
    private Long courseId;

    @NotNull(message = "Title is required")
    @Column("title")
    private String title;

    @NotNull(message = "Order index is required")
    @Column("order_index")
    private Integer orderIndex;

    @CreatedDate
    @Column("created_at")
    private LocalDateTime createdAt;
}