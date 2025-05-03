package com.footprints.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "lecture_content")
@Getter
@Setter
@NoArgsConstructor
public class LectureContent {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID lectureId;

    @Column(columnDefinition = "jsonb", nullable = false)
    private String cache;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private OffsetDateTime createdAt;

    @UpdateTimestamp
    @Column(nullable = false)
    private OffsetDateTime updatedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LectureContent that = (LectureContent) o;
        return Objects.equals(lectureId, that.lectureId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lectureId);
    }
}