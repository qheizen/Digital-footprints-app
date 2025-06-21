package com.footprints.repositories;

import com.footprints.entities.LectureContent;
import com.footprints.entities.Lesson;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LectureContentRepository extends CrudRepository<LectureContent, Long>, PagingAndSortingRepository<LectureContent, Long> {
}
