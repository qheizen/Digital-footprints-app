package com.footprints.services;

import com.footprints.dto.response.CourseResponse;
import com.footprints.entities.Course;
import com.footprints.mappers.CourseMapper;
import com.footprints.repositories.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    public List<CourseResponse> getAllCourses(Integer difficulty) {
        if (difficulty != null) {
            return courseRepository.findByDifficultyLevel(difficulty, PageRequest.of(0, Integer.MAX_VALUE))
                    .stream()
                    .map(courseMapper::toResponse)
                    .collect(Collectors.toList());
        }

        return StreamSupport.stream(courseRepository.findAll().spliterator(), false)
                .map(courseMapper::toResponse)
                .collect(Collectors.toList());
    }

    public CourseResponse getCourseById(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        return courseMapper.toResponse(course);
    }
}