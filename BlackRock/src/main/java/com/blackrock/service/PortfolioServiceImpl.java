package com.blackrock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blackrock.dao.PortfolioDao;

@Service
public class PortfolioServiceImpl implements PortfolioService {

	@Autowired
	private PortfolioDao portfolioDao;

	@Override
	public List<String> getAllResults() {
		// TODO Auto-generated method stub

		return portfolioDao.retrieveAllPortFolios();

	}

}
