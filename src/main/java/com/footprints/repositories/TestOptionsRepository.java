package com.footprints.repositories;

import com.footprints.entities.TestOptions;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestOptionsRepository extends CrudRepository<TestOptions, Long> {
}