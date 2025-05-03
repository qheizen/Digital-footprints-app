package com.footprints.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(
        uniqueConstraints = @UniqueConstraint(
                name = "uq_lesson_progress",
                columnNames = {"lesson_id", "user_id"}
        )
)
public class LessonProgress {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // Надежная генерация ID
    private UUID progressId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "lesson_id", nullable = false)
    private Lesson lesson;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private boolean lectureCompleted = false;

    @Column(nullable = false)
    private boolean practicalCompleted = false;

    @Column
    private Integer practicalScore;

    @Column(nullable = false)
    private boolean testCompleted = false;

    @Column
    private Integer testScore;

    @UpdateTimestamp // Автоматическое управление временем
    @Column(nullable = false)
    private OffsetDateTime lastUpdated;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private CompletionStatus completionStatus = CompletionStatus.NOT_OPENED;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LessonProgress that = (LessonProgress) o;
        return Objects.equals(progressId, that.progressId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(progressId);
    }
}