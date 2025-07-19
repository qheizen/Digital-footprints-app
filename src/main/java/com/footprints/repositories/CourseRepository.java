package com.footprints.repositories;

import com.footprints.entities.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long>, PagingAndSortingRepository<Course, Long> {

    Page<Course> findByDifficultyLevel(Integer difficultyLevel, Pageable pageable);

    Optional<Course> findByTitle(String title);

    @Query("""
        SELECT c.* FROM courses c JOIN keywords k ON c.keyword_id = k.id WHERE LOWER(k.word) LIKE LOWER(CONCAT('%', :keyword, '%'))
        """)
    Page<Course> findByKeywordContainingIgnoreCase(
            @Param("keyword") String keyword,
            Pageable pageable
    );

}
