package com.compliance.repo.repository;


import java.util.Collection;

import org.springframework.stereotype.Repository;

import com.compliance.repo.entity.Party;
import com.compliance.write.repo.repository.AbstractWriteRepo;

@Repository
public interface PartyRepository extends  AbstractWriteRepo<Party, Long> {
	
	Collection<Party> findAll();

}
