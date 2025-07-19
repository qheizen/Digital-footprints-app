package com.footprints.repositories;

import com.footprints.entities.UserStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserStatusRepository extends CrudRepository<UserStatus, Long> {

    Optional<UserStatus> findByUserId(Long user_id);

}
