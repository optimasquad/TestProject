package com.compliance.repo.repository;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import com.compliance.repo.entity.Person;
import com.compliance.write.repo.repository.AbstractWriteRepo;

@Repository
public interface PersonRepository extends AbstractWriteRepo<Person, Long> {

	Collection<Person> findAll();

}
