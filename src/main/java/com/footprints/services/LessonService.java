package com.footprints.services;

import com.footprints.dto.response.LessonResponse;
import com.footprints.entities.Lesson;
import com.footprints.mappers.LessonMapper;
import com.footprints.repositories.LessonRepository;
import com.footprints.repositories.LessonSectionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LessonService {

    private final LessonRepository lessonRepository;
    private final LessonSectionRepository sectionRepository;
    private final LessonMapper lessonMapper;

    public List<LessonResponse> getLessonsByCourseId(Long courseId) {
        List<Lesson> lessons = lessonRepository.findByCourseId(courseId);
        return lessons.stream()
                .map(lesson -> {
                    int count = sectionRepository.findByLessonId(lesson.getLessonId()).size();
                    return lessonMapper.toResponse(lesson, count);
                })
                .collect(Collectors.toList());
    }

    public LessonResponse getLessonById(Long lessonId) {
        Lesson lesson = lessonRepository.findById(lessonId)
                .orElseThrow(() -> new RuntimeException("Lesson not found"));
        int count = sectionRepository.findByLessonId(lessonId).size();
        return lessonMapper.toResponse(lesson, count);
    }
}