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
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID lessonId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(nullable = false)
    private int lessonOrder;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lecture_id")
    private LectureContent lecture;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "practical_id")
    private PracticalContent practical;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "test_id")
    private TestContent test;

    @Column(nullable = false, updatable = false)
    private OffsetDateTime createdAt = OffsetDateTime.now();

    @Column(nullable = false)
    private OffsetDateTime updatedAt = OffsetDateTime.now();

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = OffsetDateTime.now();
    }
}