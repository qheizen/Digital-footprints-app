package com.footprints.repositories;

import com.footprints.entities.PracticeContent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PracticeContentRepository extends CrudRepository<PracticeContent, Long> {

    List<PracticeContent> findBySectionId(Long sectionId);

    Optional<PracticeContent> findByOrderIndexAndSectionId(Integer orderIndex, Long sectionId);
}