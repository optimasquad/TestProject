package com.trade.service

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import com.trade.common.Tradeconstants
import com.trade.repository.BannerRepository


@Service
@Transactional
class HomePageService {

	@Autowired
	BannerRepository bannerRepository;

	static final org.slf4j.Logger logger = LoggerFactory.getLogger(HomePageService.class)

	public Map homePageData() {
		logger.info "Entering homepage data"
		List<BannerRepository> bannerRepositoryList = bannerRepository.findByShowInUI("1");
		logger.info "List returne ${bannerRepositoryList.size()}"

		def returnMap = [:]

		returnMap[Tradeconstants.BANNER_KEY] = bannerRepositoryList;

		logger.info "Home Page Service ends here."

		return returnMap
	}
}
