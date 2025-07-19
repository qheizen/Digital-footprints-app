package com.footprints.repositories;

import com.footprints.entities.UserCourseStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserCourseStatusRepository extends CrudRepository<UserCourseStatus, Long>{

    Optional<UserCourseStatus> findByUserIdAndCourseId(Long userId, Long courseId);

    List<UserCourseStatus> findByUserId(Long userId);

}