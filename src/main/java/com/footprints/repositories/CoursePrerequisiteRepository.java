package com.footprints.repositories;

import com.footprints.entities.CoursePrerequisite;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface CoursePrerequisiteRepository extends JpaRepository<CoursePrerequisite, UUID> {
    List<CoursePrerequisite> findByCourseCourseId(UUID courseId);
}