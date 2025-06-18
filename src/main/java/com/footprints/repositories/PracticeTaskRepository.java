package com.footprints.repositories;

import com.footprints.entities.PracticeTask;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PracticeTaskRepository extends PagingAndSortingRepository<PracticeTask, Long> {

    List<PracticeTask> findBySectionId(Long sectionId);

    Optional<PracticeTask> findBySectionIdAndOrderIndex(Long sectionId, Integer orderIndex);
}