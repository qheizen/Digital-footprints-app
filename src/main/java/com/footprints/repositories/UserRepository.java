package com.footprints.repositories;

import com.footprints.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends CrudRepository<User, Long>, PagingAndSortingRepository<User, Long> {

    Optional<User> findByUserEmail(String email);

    List<User> findByUsername(String username);

    boolean existsByUserEmail(String email);
}