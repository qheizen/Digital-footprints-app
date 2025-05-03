package com.footprints.services;

import com.footprints.dto.LessonDto;
import com.footprints.entities.Lesson;
import com.footprints.entities.Course;
import com.footprints.repositories.LessonRepository;
import com.footprints.repositories.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class LessonService {
    private final LessonRepository lessonRepo;
    private final CourseRepository courseRepo;

    public LessonService(LessonRepository lessonRepo, CourseRepository courseRepo) {
        this.lessonRepo = lessonRepo;
        this.courseRepo = courseRepo;
    }

    public LessonDto createLesson(LessonDto dto) {
        Course course = courseRepo.findById(dto.getCourseId())
                .orElseThrow(() -> new RuntimeException("Course not found"));
        Lesson lesson = new Lesson();
        lesson.setCourse(course);
        lesson.setLessonOrder(dto.getLessonOrder());
        Lesson saved = lessonRepo.save(lesson);
        return new LessonDto(saved.getLessonId(), course.getCourseId(), saved.getLessonOrder());
    }

    public List<LessonDto> listLessons(UUID courseId) {
        return lessonRepo.findByCourseCourseIdOrderByLessonOrder(courseId).stream()
                .map(l -> new LessonDto(l.getLessonId(), l.getCourse().getCourseId(), l.getLessonOrder()))
                .collect(Collectors.toList());
    }

    public LessonDto getLesson(UUID lessonId) {
        Lesson l = lessonRepo.findById(lessonId)
                .orElseThrow(() -> new RuntimeException("Lesson not found"));
        return new LessonDto(l.getLessonId(), l.getCourse().getCourseId(), l.getLessonOrder());
    }
}