package com.footprints.repositories;

import com.footprints.entities.UserSectionStatus;
import org.springframework.data.repository.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface UserSectionStatusRepository extends Repository<UserSectionStatus, Void> {

    UserSectionStatus save(UserSectionStatus status);

    Optional<UserSectionStatus> findByUserIdAndSectionId(Long userId, Long sectionId);

    List<UserSectionStatus> findByUserId(Long userId);

    List<UserSectionStatus> findByUserIdAndIsCompleted(Long userId, Boolean isCompleted);

    default void updateCompletionStatus(Long userId, Long sectionId, Boolean isCompleted) {
        Optional<UserSectionStatus> statusOpt = findByUserIdAndSectionId(userId, sectionId);
        if (statusOpt.isPresent()) {
            UserSectionStatus status = statusOpt.get();
            status.setIsCompleted(isCompleted);
            if (isCompleted != null && isCompleted) {
                status.setCompletedAt(LocalDateTime.now());
            } else {
                status.setCompletedAt(null);
            }
            save(status);
        }
    }

    default void setCompletionStatus(Long userId, Long sectionId, Boolean isCompleted) {
        UserSectionStatus status = findByUserIdAndSectionId(userId, sectionId)
                .orElseGet(UserSectionStatus::new);
        status.setUserId(userId);
        status.setSectionId(sectionId);
        status.setIsCompleted(isCompleted);

        if (isCompleted != null && isCompleted) {
            status.setCompletedAt(LocalDateTime.now());
        } else {
            status.setCompletedAt(null);
        }

        save(status);
    }
}