package com.footprints.services;

import com.footprints.dto.CourseDto;
import com.footprints.entities.Course;
import com.footprints.repositories.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CourseService {
    private final CourseRepository courseRepo;

    public CourseService(CourseRepository courseRepo) {
        this.courseRepo = courseRepo;
    }

    public CourseDto createCourse(CourseDto dto) {
        Course course = new Course();
        course.setTitle(dto.getTitle());
        course.setDescription(dto.getDescription());
        Course saved = courseRepo.save(course);
        return new CourseDto(saved.getCourseId(), saved.getTitle(), saved.getDescription());
    }

    public List<CourseDto> listCourses() {
        return courseRepo.findAll().stream()
                .map(c -> new CourseDto(c.getCourseId(), c.getTitle(), c.getDescription()))
                .collect(Collectors.toList());
    }

    public CourseDto getCourse(UUID id) {
        Course c = courseRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        return new CourseDto(c.getCourseId(), c.getTitle(), c.getDescription());
    }
}