package com.footprints.services;

import com.footprints.dto.LessonDto;
import com.footprints.entities.Course;
import com.footprints.entities.Lesson;
import com.footprints.repositories.CourseRepository;
import com.footprints.repositories.LessonRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class LessonService {
    private final LessonRepository lessonRepository;
    private final CourseRepository courseRepository;

    public LessonService(LessonRepository lessonRepository, CourseRepository courseRepository) {
        this.lessonRepository = lessonRepository;
        this.courseRepository = courseRepository;
    }

    public LessonDto getLessonById(UUID lessonId) {
        Lesson lesson = lessonRepository.findById(lessonId)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Lesson not found"));
        return toDto(lesson);
    }

    public List<LessonDto> getLessonsByCourse(UUID courseId) {
        List<Lesson> lessons = lessonRepository.findByCourse_CourseId(courseId);
        return lessons.stream().map(this::toDto).collect(Collectors.toList());
    }

    public LessonDto createLesson(UUID courseId, LessonDto dto) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Course not found"));

        Lesson lesson = new Lesson();
        lesson.setCourse(course);
        lesson.setLessonOrder(dto.getLessonOrder());
        lessonRepository.save(lesson);

        return toDto(lesson);
    }

    private LessonDto toDto(Lesson lesson) {
        LessonDto dto = new LessonDto();
        dto.setLessonId(lesson.getLessonId());
        dto.setCourseId(lesson.getCourse().getCourseId());
        dto.setLessonOrder(lesson.getLessonOrder());
        return dto;
    }
}