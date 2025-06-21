package com.footprints.controllers;

import com.footprints.dto.response.ApiResponse;
import com.footprints.dto.response.CourseResponse;
import com.footprints.services.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @Operation(summary = "Список всех курсов")
    @GetMapping
    public ApiResponse<List<CourseResponse>> getAllCourses(
            @RequestParam(required = false) Integer difficulty) {
        List<CourseResponse> courses = courseService.getAllCourses(difficulty);
        return new ApiResponse<>("success", 200, "Список курсов получен", courses);
    }

    @Operation(summary = "Получить курс по ID")
    @GetMapping("/{id}")
    public ApiResponse<CourseResponse> getCourseById(@PathVariable Long id) {
        CourseResponse course = courseService.getCourseById(id);
        return new ApiResponse<>("success", 200, "Курс найден", course);
    }
}