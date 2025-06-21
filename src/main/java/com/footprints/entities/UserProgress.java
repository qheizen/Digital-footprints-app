package com.footprints.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Persistable;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table("user_progress")
public class UserProgress implements Persistable<UserProgressId> {

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

    @Transient
    private boolean isNew = true;

    @Override
    public UserProgressId getId() {
        return new UserProgressId(userId, courseId);
    }

    @Override
    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean isNew) {
        this.isNew = isNew;
    }
}