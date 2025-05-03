package com.footprints.services;

import com.footprints.dto.ProgressDto;
import com.footprints.entities.*;
import com.footprints.repositories.CourseProgressRepository;
import com.footprints.repositories.LessonProgressRepository;
import com.footprints.repositories.LessonRepository;
import com.footprints.repositories.UserRepository;
import com.footprints.repositories.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class ProgressService {
    private final LessonProgressRepository lessonProgRepo;
    private final CourseProgressRepository courseProgRepo;
    private final LessonRepository lessonRepository;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository; // Поле добавлено

    public ProgressDto updateLessonProgress(UUID lessonId, UUID userId, boolean lectureDone, boolean practicalDone) {
        Lesson lesson = lessonRepository.findById(lessonId)
                .orElseThrow(() -> new RuntimeException("Lesson not found"));
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        LessonProgress lp = lessonProgRepo.findByLessonAndUser(lesson, user)
                .orElseGet(() -> {
                    LessonProgress newLp = new LessonProgress();
                    newLp.setLesson(lesson);
                    newLp.setUser(user);
                    return newLp;
                });

        lp.setLectureCompleted(lectureDone);
        lp.setPracticalCompleted(practicalDone);
        lp.setCompletionStatus(
                (lectureDone && practicalDone) ? CompletionStatus.FINISHED :
                        (lectureDone || practicalDone) ? CompletionStatus.IN_PROGRESS :
                                CompletionStatus.NOT_OPENED
        );

        lessonProgRepo.save(lp);
        return new ProgressDto(
                lessonId,
                userId,
                lp.getCompletionStatus(),
                null
        );
    }

    public ProgressDto updateCourseProgress(UUID courseId, UUID userId, double finalScore) {
        CourseProgress cp = courseProgRepo.findByCourse_CourseIdAndUser_UserId(courseId, userId)
                .orElseGet(() -> {
                    CourseProgress newCp = new CourseProgress();
                    newCp.setCourse(courseRepository.getReferenceById(courseId));
                    newCp.setUser(userRepository.getReferenceById(userId));
                    return newCp;
                });

        cp.setFinalScore(finalScore);
        cp.setCompletionStatus(finalScore >= 0.6 ? CompletionStatus.FINISHED : CompletionStatus.IN_PROGRESS);
        courseProgRepo.save(cp);

        return new ProgressDto(
                courseId,
                userId,
                cp.getCompletionStatus(),
                cp.getFinalScore()
        );
    }
}