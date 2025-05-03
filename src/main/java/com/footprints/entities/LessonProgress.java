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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column
    private boolean isLectureCompleted;

    @Column
    private boolean isPracticalCompleted;

    @Column
    private Integer practicalScore;

    @Column
    private boolean isTestCompleted;

    @Column
    private Integer testScore;

    @Column
    private OffsetDateTime lastUpdated = OffsetDateTime.now();

    @PreUpdate
    public void preUpdate() {
        this.lastUpdated = OffsetDateTime.now();
    }
}