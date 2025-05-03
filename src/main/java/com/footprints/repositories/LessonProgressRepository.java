package com.footprints.repositories;

import com.footprints.entities.Lesson;
import com.footprints.entities.LessonProgress;
import com.footprints.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID; // Добавлен импорт UUID

public interface LessonProgressRepository extends JpaRepository<LessonProgress, UUID> {
    Optional<LessonProgress> findByLessonAndUser(Lesson lesson, User user);
}