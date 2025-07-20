package com.footprints.repositories;

import com.footprints.entities.UserSessionLogs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSessionLogsRepository extends CrudRepository<UserSessionLogs, Long>, PagingAndSortingRepository<UserSessionLogs, Long> {

    Page<UserSessionLogs> findByUserId(Long userId, Pageable pageable);
}
