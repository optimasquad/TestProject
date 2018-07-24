package com.compliance.read.repo.repository;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public class AbstractReadRepoImpl<T, ID> extends SimpleJpaRepository<T, ID> implements AbstractReadRepo<T, ID> {

	protected final EntityManager entityManager;

	public AbstractReadRepoImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.entityManager = entityManager;
	}

}
