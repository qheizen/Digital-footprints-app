package com.footprints.repositories;

import com.footprints.entities.UserTestAnswer;
import com.footprints.entities.UserTestAnswerId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTestAnswerRepository extends CrudRepository<UserTestAnswer, UserTestAnswerId> {
}