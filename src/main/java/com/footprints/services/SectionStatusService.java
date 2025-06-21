package com.footprints.services;

import com.footprints.dto.request.SectionStatusRequest;
import com.footprints.entities.UserSectionStatus;
import com.footprints.repositories.UserSectionStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class SectionStatusService {

    private final UserSectionStatusRepository statusRepository;

    public void updateSectionStatus(SectionStatusRequest request) {
        UserSectionStatus status = statusRepository
                .findByUserIdAndSectionId(request.userId(), request.sectionId())
                .orElseGet(() -> {
                    UserSectionStatus newStatus = new UserSectionStatus();
                    newStatus.setUserId(request.userId());
                    newStatus.setSectionId(request.sectionId());
                    return newStatus;
                });

        if (request.isCompleted()) {
            status.setIsCompleted(true);
            status.setCompletedAt(LocalDateTime.now());
        } else {
            status.setIsCompleted(false);
            status.setCompletedAt(null);
        }
        statusRepository.save(status);
    }
}