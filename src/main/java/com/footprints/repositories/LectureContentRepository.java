package com.footprints.repositories;

import com.footprints.entities.LectureContent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LectureContentRepository extends CrudRepository<LectureContent, Long> {
}