package com.footprints.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "lecture_content")
@Getter
@Setter
@NoArgsConstructor
public class LectureContent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID lectureId;

    @Column(columnDefinition = "jsonb")
    private String cache;

    // Время создания записи
    @Column(nullable = false, updatable = false)
    private OffsetDateTime createdAt = OffsetDateTime.now();

    // Время последнего обновления
    @Column(nullable = false)
    private OffsetDateTime updatedAt = OffsetDateTime.now();

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = OffsetDateTime.now();
    }
}