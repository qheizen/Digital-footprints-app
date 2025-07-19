package com.footprints.repositories;

import com.footprints.entities.Keyword;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeywordRepository extends CrudRepository<Keyword, Long>, PagingAndSortingRepository<Keyword, Long> {
}