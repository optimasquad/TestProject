package com.compliance.write.repo.repository;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public class AbstractWriteRepoImpl<T, ID> extends SimpleJpaRepository<T, ID> implements AbstractWriteRepo<T, ID> {

	protected final EntityManager entityManager;

	public AbstractWriteRepoImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.entityManager = entityManager;
	}

}
