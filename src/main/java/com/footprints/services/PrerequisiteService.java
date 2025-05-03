package com.footprints.services;

import com.footprints.entities.CoursePrerequisite;
import com.footprints.entities.CourseProgress;
import com.footprints.entities.CompletionStatus;
import com.footprints.repositories.CoursePrerequisiteRepository;
import com.footprints.repositories.CourseProgressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PrerequisiteService {
    private final CoursePrerequisiteRepository prerequisiteRepository;
    private final CourseProgressRepository courseProgressRepository;

    public boolean hasCompletedAllPrerequisites(UUID courseId, UUID userId) {
        List<CoursePrerequisite> prerequisites = prerequisiteRepository.findByCourse_CourseId(courseId);
        return prerequisites.stream().allMatch(cp -> {
            CourseProgress progress = courseProgressRepository.findByCourse_CourseIdAndUser_UserId(
                    cp.getPrerequisite().getCourseId(),
                    userId
            ).orElse(null);
            return progress != null && progress.getCompletionStatus() == CompletionStatus.FINISHED;
        });
    }
}