package com.footprints.controllers;

import com.footprints.dto.LessonDto;
import com.footprints.services.LessonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/lessons")
public class LessonController {
    private final LessonService lessonService;

    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<LessonDto>> getLessonsByCourse(@PathVariable UUID courseId) {
        return ResponseEntity.ok(lessonService.getLessonsByCourse(courseId));
    }

    @GetMapping("/{lessonId}")
    public ResponseEntity<LessonDto> getLesson(@PathVariable UUID lessonId) {
        return ResponseEntity.ok(lessonService.getLessonById(lessonId));
    }

    @PostMapping("/course/{courseId}")
    public ResponseEntity<LessonDto> createLesson(
            @PathVariable UUID courseId,
            @RequestBody LessonDto lessonDto
    ) {
        return ResponseEntity.ok(lessonService.createLesson(courseId, lessonDto));
    }
}