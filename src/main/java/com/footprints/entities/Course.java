package com.footprints.entities;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.*;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("courses")
public class Course {

    @Id
    @Column("id")
    private Long courseId;

    @NotNull(message = "Title is required")
    @Column("title")
    private String title;

    @Column("description")
    private String description;

    @Column("key_word")
    private String keyWord;

    @NotNull(message = "Difficulty level is required")
    @Column("difficulty_level")
    private Integer difficultyLevel;

    @CreatedDate
    @Column("created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column("updated_at")
    private LocalDateTime updatedAt;
}
