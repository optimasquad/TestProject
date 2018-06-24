package com.blackrock.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.blackrock.entity.Banner;

@Transactional
@Repository
public class PortfolioDaoImpl implements PortfolioDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<String> retrieveAllPortFolios() {
		// TODO Auto-generated method stub

		String hql = "SELECT ID FROM Banner";

		//List<Banner> listOfBanner = (List<Banner>) entityManager.createNativeQuery(hql).getResultList();
		// List<Banner> listOfBanner = (List<Banner>)
		// entityManager.createQuery(hql).getResultList();

		//istOfBanner.forEach(System.out::println);

		return null;

	}

}
