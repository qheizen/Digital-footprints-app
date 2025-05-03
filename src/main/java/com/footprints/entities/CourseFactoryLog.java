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
public class CourseFactoryLog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID logId;

    @Column(nullable = false)
    private String operationType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String xmlContent;

    @Column(nullable = false)
    private String status;

    @Column(columnDefinition = "TEXT")
    private String errorMessage;

    @Column
    private final OffsetDateTime createdAt = OffsetDateTime.now();
}