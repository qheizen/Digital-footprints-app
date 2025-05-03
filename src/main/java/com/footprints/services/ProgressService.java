package com.footprints.services;

import com.footprints.dto.ProgressDto;
import com.footprints.entities.LessonProgress;
import com.footprints.entities.CourseProgress;
import com.footprints.entities.CompletionStatus;
import com.footprints.repositories.LessonProgressRepository;
import com.footprints.repositories.CourseProgressRepository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.UUID;

@Service
public class ProgressService {
    private final LessonProgressRepository lessonProgRepo;
    private final CourseProgressRepository courseProgRepo;

    public ProgressService(LessonProgressRepository lessonProgRepo,
                           CourseProgressRepository courseProgRepo) {
        this.lessonProgRepo = lessonProgRepo;
        this.courseProgRepo = courseProgRepo;
    }

    @Transactional
    public ProgressDto updateLessonProgress(UUID lessonId, UUID userId, boolean lectureDone, boolean practicalDone) {
        LessonProgress lp = lessonProgRepo.findByLessonLessonIdAndUserUserId(lessonId, userId)
                .orElseGet(() -> new LessonProgress(lessonId, userId));
        lp.setLectureCompleted(lectureDone);
        lp.setPracticalCompleted(practicalDone);
        if (lectureDone && practicalDone) lp.setCompletionStatus(CompletionStatus.FINISHED);
        else if (lectureDone || practicalDone) lp.setCompletionStatus(CompletionStatus.IN_PROGRESS);
        lessonProgRepo.save(lp);
        return new ProgressDto(lessonId, userId, lp.getCompletionStatus(), null);
    }

    @Transactional
    public ProgressDto updateCourseProgress(UUID courseId, UUID userId, double finalScore) {
        CourseProgress cp = courseProgRepo.findByCourseCourseIdAndUserUserId(courseId, userId)
                .orElseGet(() -> new CourseProgress(courseId, userId));
        cp.setFinalScore(finalScore);
        cp.setCompletionStatus(finalScore >= 0.6 ? CompletionStatus.FINISHED : CompletionStatus.IN_PROGRESS);
        courseProgRepo.save(cp);
        return new ProgressDto(courseId, userId, cp.getCompletionStatus(), cp.getFinalScore());
    }
}