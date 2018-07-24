package com.compliance.write.repo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface AbstractWriteRepo<T, ID> extends CrudRepository<T, ID> {
	
}
