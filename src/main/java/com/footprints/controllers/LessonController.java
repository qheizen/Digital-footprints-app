package com.footprints.controllers;

import com.footprints.dto.response.ApiResponse;
import com.footprints.dto.response.LessonResponse;
import com.footprints.services.LessonService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/lessons")
@RequiredArgsConstructor
public class LessonController {

    private final LessonService lessonService;

    @Operation(summary = "Получить уроки по ID курса")
    @GetMapping("/course/{courseId}")
    public ApiResponse<List<LessonResponse>> getLessonsByCourseId(@PathVariable Long courseId) {
        List<LessonResponse> lessons = lessonService.getLessonsByCourseId(courseId);
        return new ApiResponse<>("success", 200, "Уроки курса получены", lessons);
    }

    @Operation(summary = "Получить урок по ID")
    @GetMapping("/{lessonId}")
    public ApiResponse<LessonResponse> getLessonById(@PathVariable Long lessonId) {
        LessonResponse lesson = lessonService.getLessonById(lessonId);
        return new ApiResponse<>("success", 200, "Урок найден", lesson);
    }
}