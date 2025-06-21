package com.footprints.services;

import com.footprints.dto.request.ProgressUpdateRequest;
import com.footprints.dto.response.UserProgressResponse;
import com.footprints.entities.UserProgress;
import com.footprints.entities.UserProgressId;
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
        UserProgressId id = new UserProgressId(request.userId(), request.courseId());
        UserProgress progress = progressRepository.findById(id)
                .orElseGet(() -> {
                    UserProgress newProg = new UserProgress();
                    newProg.setUserId(request.userId());
                    newProg.setCourseId(request.courseId());
                    newProg.setNew(true);
                    return newProg;
                });

        progress.setCompletionPercentage(request.completionPercentage());
        progress.setCorrectnessPercentage(request.correctnessPercentage());
        progress.setLastAccessed(LocalDateTime.now());
        progress.setNew(false);
        progressRepository.save(progress);
        return progressMapper.toResponse(progress);
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