package com.footprints.controllers;

import com.footprints.dto.request.ProgressUpdateRequest;
import com.footprints.dto.response.ApiResponse;
import com.footprints.dto.response.UserProgressResponse;
import com.footprints.services.UserProgressService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/progress")
@RequiredArgsConstructor
public class UserProgressController {

    private final UserProgressService userProgressService;

    @Operation(summary = "Обновить прогресс пользователя по курсу")
    @PostMapping
    public ApiResponse<UserProgressResponse> updateProgress(
            @RequestBody ProgressUpdateRequest request) {
        UserProgressResponse response = userProgressService.updateProgress(request);
        return new ApiResponse<>("success", 200, "Прогресс обновлён", response);
    }

    @Operation(summary = "Получить прогресс пользователя по курсу")
    @GetMapping("/{userId}/{courseId}")
    public ApiResponse<UserProgressResponse> getProgress(
            @PathVariable Long userId, @PathVariable Long courseId) {
        UserProgressResponse response = userProgressService.getProgress(userId, courseId);
        return new ApiResponse<>("success", 200, "Прогресс получен", response);
    }

    @Operation(summary = "Получить прогресс пользователя по всем курсам")
    @GetMapping("/user/{userId}")
    public ApiResponse<List<UserProgressResponse>> getProgressByUser(@PathVariable Long userId) {
        List<UserProgressResponse> list = userProgressService.getProgressByUser(userId);
        return new ApiResponse<>("success", 200, "Прогресс пользователя получен", list);
    }
}