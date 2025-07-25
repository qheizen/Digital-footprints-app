package com.footprints.repositories;

import com.footprints.entities.Lesson;
import com.footprints.entities.TestQuestion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TestQuestionRepository extends CrudRepository<TestQuestion, Long>, PagingAndSortingRepository<TestQuestion, Long> {

    List<TestQuestion> findBySectionId(Long sectionId);

    Optional<TestQuestion> findBySectionIdAndOrderIndex(Long sectionId, Integer orderIndex);
}