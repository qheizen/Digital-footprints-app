package com.footprints.repositories;

import com.footprints.entities.Course;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long>, PagingAndSortingRepository<Course, Long> {

    Page<Course> findByDifficultyLevel(Integer difficultyLevel, Pageable pageable);

    Page<Course> findByDifficultyLevelLessThan(Integer maxLevel, Pageable pageable);

    Optional<Course> findByTitle(String title);
}