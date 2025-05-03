package com.footprints.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class LessonProgress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID progressId;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column
    private boolean lectureCompleted;

    @Column
    private boolean practicalCompleted;

    @Column
    private Integer practicalScore;

    @Column
    private boolean testCompleted;

    @Column
    private Integer testScore;

    @Column
    private OffsetDateTime lastUpdated = OffsetDateTime.now();

    @Enumerated(EnumType.STRING)
    private CompletionStatus completionStatus;

    @PreUpdate
    public void preUpdate() {
        this.lastUpdated = OffsetDateTime.now();
    }
}