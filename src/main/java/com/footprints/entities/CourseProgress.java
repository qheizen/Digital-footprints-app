package com.footprints.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CourseProgress {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // Явная стратегия
    private UUID courseProgressId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CompletionStatus completionStatus;

    @Column
    private Double finalScore;

    @Column(nullable = false, updatable = false)
    private final OffsetDateTime createdAt = OffsetDateTime.now();

    @PreUpdate
    public void preUpdate() {
        OffsetDateTime lastUpdated = OffsetDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseProgress that = (CourseProgress) o;
        return Objects.equals(courseProgressId, that.courseProgressId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseProgressId);
    }
}