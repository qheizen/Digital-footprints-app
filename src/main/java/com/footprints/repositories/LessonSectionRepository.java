package com.footprints.repositories;

import com.footprints.entities.LessonSection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LessonSectionRepository extends CrudRepository<LessonSection, Long> {

    List<LessonSection> findByLessonId(Long lessonId);

    Optional<LessonSection> findByOrderIndexAndLessonId(Integer orderIndex, Long lessonId);
}