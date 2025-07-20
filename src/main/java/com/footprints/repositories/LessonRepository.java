package com.footprints.repositories;

import com.footprints.entities.Lesson;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LessonRepository extends CrudRepository<Lesson, Long> {

    List<Lesson> findByCourseId(Long courseId);

    Optional<Lesson> findByOrderIndexAndCourseId(Integer orderIndex, Long courseId);

    boolean existsByTitle(String title);
}