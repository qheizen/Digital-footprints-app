package com.footprints.dto;

import java.util.UUID;
import com.footprints.entities.CompletionStatus;


public class ProgressDto {
    private UUID contentId;       // lessonId или courseId
    private UUID userId;
    private CompletionStatus status;
    private Double finalScore;    // для курса

    public ProgressDto() {}

    public ProgressDto(UUID contentId, UUID userId, CompletionStatus status, Double finalScore) {
        this.contentId = contentId;
        this.userId = userId;
        this.status = status;
        this.finalScore = finalScore;
    }

    public UUID getContentId() { return contentId; }
    public void setContentId(UUID contentId) { this.contentId = contentId; }
    public UUID getUserId() { return userId; }
    public void setUserId(UUID userId) { this.userId = userId; }
    public CompletionStatus getStatus() { return status; }
    public void setStatus(CompletionStatus status) { this.status = status; }
    public Double getFinalScore() { return finalScore; }
    public void setFinalScore(Double finalScore) { this.finalScore = finalScore; }
}