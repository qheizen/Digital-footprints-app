package com.footprints.services;

import com.footprints.dto.request.ProgressUpdateRequest;
import com.footprints.dto.response.UserProgressResponse;
import com.footprints.entities.UserProgress;
import com.footprints.mappers.UserProgressMapper;
import com.footprints.repositories.UserProgressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserProgressService {

    private final UserProgressRepository progressRepository;
    private final UserProgressMapper progressMapper;

    public UserProgressResponse updateProgress(ProgressUpdateRequest request) {
        UserProgress progress = progressRepository.findByUserIdAndCourseId(request.userId(), request.courseId())
                .orElseGet(() -> {
                    UserProgress p = new UserProgress();
                    p.setUserId(request.userId());
                    p.setCourseId(request.courseId());
                    return p;
                });

        progress.setCompletionPercentage(request.completionPercentage());
        progress.setCorrectnessPercentage(request.correctnessPercentage());
        progress.setLastAccessed(LocalDateTime.now());

        UserProgress saved = progressRepository.save(progress);
        return progressMapper.toResponse(saved);
    }

    public UserProgressResponse getProgress(Long userId, Long courseId) {
        return progressRepository.findByUserIdAndCourseId(userId, courseId)
                .map(progressMapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Progress not found"));
    }

    public List<UserProgressResponse> getProgressByUser(Long userId) {
        return progressRepository.findByUserId(userId).stream()
                .map(progressMapper::toResponse)
                .collect(Collectors.toList());
    }
}
