package com.footprints.controllers;

import com.footprints.dto.ProgressDto;
import com.footprints.services.ProgressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/progress")
public class ProgressController {
    private final ProgressService progressService;

    public ProgressController(ProgressService progressService) {
        this.progressService = progressService;
    }

    @PostMapping("/lesson/{lessonId}/user/{userId}")
    public ResponseEntity<ProgressDto> lessonProgress(
            @PathVariable UUID lessonId,
            @PathVariable UUID userId,
            @RequestParam boolean lectureDone,
            @RequestParam boolean practicalDone) {
        return ResponseEntity.ok(
                progressService.updateLessonProgress(lessonId, userId, lectureDone, practicalDone)
        );
    }

    @PostMapping("/course/{courseId}/user/{userId}")
    public ResponseEntity<ProgressDto> courseProgress(
            @PathVariable UUID courseId,
            @PathVariable UUID userId,
            @RequestParam double finalScore) {
        return ResponseEntity.ok(
                progressService.updateCourseProgress(courseId, userId, finalScore)
        );
    }
}