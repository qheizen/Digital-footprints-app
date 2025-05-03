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
public class CourseProgress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID courseProgressId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CompletionStatus completionStatus;

    @Column
    private Double finalScore;

    @Column
    private OffsetDateTime lastUpdated = OffsetDateTime.now();

    @PreUpdate
    public void preUpdate() {
        this.lastUpdated = OffsetDateTime.now();
    }
}