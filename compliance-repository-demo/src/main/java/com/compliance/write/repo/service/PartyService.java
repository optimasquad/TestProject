package com.compliance.write.repo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compliance.repo.repository.PartyRepository;

@Service
public class PartyService implements IPartyService {

	@Autowired
	private PartyRepository partyRepo;

	@Override
	public void Partydelete() {
		
		partyRepo.deleteById(1l);
	}

}
