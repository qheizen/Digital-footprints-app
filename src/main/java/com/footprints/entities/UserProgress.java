package com.footprints.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table("user_progress")
public class UserProgress {

    @Id
    @Column("id")
    private Long id;

    @Column("user_id")
    private Long userId;

    @Column("course_id")
    private Long courseId;

    @Column("completion_percentage")
    private Integer completionPercentage;

    @Column("correctness_percentage")
    private Integer correctnessPercentage;

    @Column("last_accessed")
    private LocalDateTime lastAccessed;
}
