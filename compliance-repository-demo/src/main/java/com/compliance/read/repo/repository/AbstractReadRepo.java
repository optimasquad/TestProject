package com.compliance.read.repo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface AbstractReadRepo<T, ID > extends CrudRepository<T, ID> {
}
