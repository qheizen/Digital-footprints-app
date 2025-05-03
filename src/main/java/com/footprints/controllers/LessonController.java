package com.footprints.controllers;

import com.footprints.dto.LessonDto;
import com.footprints.services.LessonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/courses/{courseId}/lessons")
public class LessonController {
    private final LessonService lessonService;

    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @PostMapping
    public ResponseEntity<LessonDto> create(
            @PathVariable UUID courseId,
            @RequestBody LessonDto dto) {
        dto.setCourseId(courseId);
        return ResponseEntity.ok(lessonService.createLesson(dto));
    }

    @GetMapping
    public ResponseEntity<List<LessonDto>> list(@PathVariable UUID courseId) {
        return ResponseEntity.ok(lessonService.listLessons(courseId));
    }

    @GetMapping("/{lessonId}")
    public ResponseEntity<LessonDto> get(
            @PathVariable UUID courseId,
            @PathVariable UUID lessonId) {
        return ResponseEntity.ok(lessonService.getLesson(lessonId));
    }
}