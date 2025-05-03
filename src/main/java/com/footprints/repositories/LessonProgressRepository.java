package com.footprints.repositories;

import com.footprints.entities.LessonProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;

public interface LessonProgressRepository extends JpaRepository<LessonProgress, UUID> {
    Optional<LessonProgress> findByLessonLessonIdAndUserUserId(UUID lessonId, UUID userId);
}