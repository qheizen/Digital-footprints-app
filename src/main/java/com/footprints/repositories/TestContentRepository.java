package com.footprints.repositories;

import com.footprints.entities.TestContent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestContentRepository extends CrudRepository<TestContent, Long> {

    List<TestContent> findBySectionId(Long sectionId);
}