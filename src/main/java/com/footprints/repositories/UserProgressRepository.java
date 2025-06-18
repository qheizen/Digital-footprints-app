package com.footprints.repositories;

import com.footprints.entities.UserProgress;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public interface UserProgressRepository extends Repository<UserProgress, Void> {

    UserProgress save(UserProgress userProgress);

    Optional<UserProgress> findByUserIdAndCourseId(Long userId, Long courseId);

    List<UserProgress> findByUserId(Long userId);

    List<UserProgress> findByCourseId(Long courseId);

    void deleteByUserIdAndCourseId(Long userId, Long courseId);

    default void updateCompletionPercentage(Long userId, Long courseId, Integer completionPercentage) {
        findByUserIdAndCourseId(userId, courseId).ifPresent(progress -> {
            progress.setCompletionPercentage(completionPercentage);
            progress.setLastAccessed(LocalDateTime.now());
            save(progress);
        });
    }

    default void updateCorrectnessPercentage(Long userId, Long courseId, Integer correctnessPercentage) {
        findByUserIdAndCourseId(userId, courseId).ifPresent(progress -> {
            progress.setCorrectnessPercentage(correctnessPercentage);
            progress.setLastAccessed(LocalDateTime.now());
            save(progress);
        });
    }
}