package com.footprints.repositories;

import com.footprints.entities.Lesson;
import com.footprints.entities.LessonSection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LessonSectionRepository extends CrudRepository<LessonSection, Long>, PagingAndSortingRepository<LessonSection, Long> {

    List<LessonSection> findByLessonId(Long lessonId);

    List<LessonSection> findBySectionType(String sectionType);

    Optional<LessonSection> findByLessonIdAndOrderIndex(Long lessonId, Integer orderIndex);
}