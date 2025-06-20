package com.footprints.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("user_progress")
public class UserProgress {

    @Id
    @Column("user_id")
    private Long userId;

    @Id
    @Column("course_id")
    private Long courseId;

    @Column("completion_percentage")
    private Integer completionPercentage;

    @Column("correctness_percentage")
    private Integer correctnessPercentage;

    @Column("last_accessed")
    private LocalDateTime lastAccessed;
}