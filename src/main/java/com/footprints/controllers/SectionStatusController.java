package com.footprints.controllers;

import com.footprints.dto.request.SectionStatusRequest;
import com.footprints.dto.response.ApiResponse;
import com.footprints.services.SectionStatusService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/sections")
@RequiredArgsConstructor
public class SectionStatusController {

    private final SectionStatusService sectionStatusService;

    @Operation(summary = "Обновить статус завершения секции для пользователя")
    @PostMapping("/status")
    public ApiResponse<Void> updateSectionStatus(@RequestBody SectionStatusRequest request) {
        sectionStatusService.updateSectionStatus(request);
        return new ApiResponse<>("success", 200, "Статус секции обновлён", null);
    }
}