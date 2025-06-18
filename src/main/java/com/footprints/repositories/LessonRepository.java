package com.footprints.repositories;

import com.footprints.entities.Lesson;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LessonRepository extends PagingAndSortingRepository<Lesson, Long> {

    List<Lesson> findByCourseId(Long courseId);

    Optional<Lesson> findByCourseIdAndOrderIndex(Long courseId, Integer orderIndex);
}