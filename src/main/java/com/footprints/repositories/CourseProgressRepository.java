package com.footprints.repositories;

import com.footprints.entities.CourseProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;

public interface CourseProgressRepository extends JpaRepository<CourseProgress, UUID> {
    Optional<CourseProgress> findByCourseCourseIdAndUserUserId(UUID courseId, UUID userId);
}