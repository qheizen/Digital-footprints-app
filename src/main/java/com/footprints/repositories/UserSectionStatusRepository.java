package com.footprints.repositories;

import com.footprints.entities.UserSectionStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserSectionStatusRepository extends CrudRepository<UserSectionStatus, Integer> {

    Optional<UserSectionStatus> findByUserIdAndSectionId(Long userId, Long sectionId);

    List<UserSectionStatus> findByUserId(Long userId);

    List<UserSectionStatus> findByUserIdAndIsCompleted(Long userId, Boolean isCompleted);
}
