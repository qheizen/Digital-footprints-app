package com.footprints.controllers;

import com.footprints.dto.response.ApiResponse;
import com.footprints.dto.response.SectionContentResponse;
import com.footprints.services.SectionService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/sections")
@RequiredArgsConstructor
public class SectionController {

    private final SectionService sectionService;

    @Operation(summary = "Получить содержимое секции урока по ID секции")
    @GetMapping("/{sectionId}/content")
    public ApiResponse<SectionContentResponse> getSectionContent(@PathVariable Long sectionId) {
        SectionContentResponse content = sectionService.getSectionContent(sectionId);
        return new ApiResponse<>("success", 200, "Содержимое секции получено", content);
    }
}