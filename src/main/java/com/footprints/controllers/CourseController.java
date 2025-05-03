package com.footprints.controllers;

import com.footprints.dto.CourseDto;
import com.footprints.services.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public ResponseEntity<CourseDto> create(@RequestBody CourseDto dto) {
        return ResponseEntity.ok(courseService.createCourse(dto));
    }

    @GetMapping
    public ResponseEntity<List<CourseDto>> list() {
        return ResponseEntity.ok(courseService.listCourses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDto> get(@PathVariable UUID id) {
        return ResponseEntity.ok(courseService.getCourse(id));
    }
}