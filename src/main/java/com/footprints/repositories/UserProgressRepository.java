// src/main/java/com/footprints/repositories/UserProgressRepository.java
package com.footprints.repositories;

import com.footprints.entities.UserProgress;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserProgressRepository extends CrudRepository<UserProgress, Long> {

    Optional<UserProgress> findByUserIdAndCourseId(Long userId, Long courseId);

    List<UserProgress> findByUserId(Long userId);

    List<UserProgress> findByCourseId(Long courseId);

    void deleteByUserIdAndCourseId(Long userId, Long courseId);
}
