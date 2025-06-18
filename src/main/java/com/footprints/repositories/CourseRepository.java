package com.footprints.repositories;

import com.footprints.entities.Course;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
public interface CourseRepository extends PagingAndSortingRepository<Course, Long> {

    Page<Course> findWithDifficulty(String difficultLevel, Pageable pageable);

    @Query("SELECT c FROM Course c WHERE c.difficultLevel < :maxLevel")
    Page<Course> findWithDifficultyBelow(@Param("maxLevel") int maxLevel, Pageable pageable);

    Optional<Course> findByTitle(String title);
}
