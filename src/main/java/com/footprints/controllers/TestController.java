package com.footprints.controllers;

import com.footprints.dto.request.TestAnswerRequest;
import com.footprints.dto.response.ApiResponse;
import com.footprints.services.TestService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tests")
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @Operation(summary = "Отправить ответы на тестовые вопросы")
    @PostMapping("/answers")
    public ApiResponse<Void> submitAnswers(@RequestBody List<TestAnswerRequest> requests) {
        testService.submitAnswers(requests);
        return new ApiResponse<>("success", 200, "Ответы получены и обработаны", null);
    }
}