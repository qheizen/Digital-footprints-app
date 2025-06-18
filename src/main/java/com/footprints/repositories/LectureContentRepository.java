package com.footprints.repositories;

import com.footprints.entities.LectureContent;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LectureContentRepository extends PagingAndSortingRepository<LectureContent, Long> {
}
