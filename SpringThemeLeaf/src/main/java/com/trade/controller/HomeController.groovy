/**
 * 
 */
package com.trade.controller

import javax.servlet.ServletContext

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

import com.trade.common.Tradeconstants
import com.trade.service.HomePageService



/**
 * @author jatin
 * 
 * This is the Controller class for the User to be called directly 
 * from the WebConfig while entering the application
 *
 */

@Controller
class HomeController  extends AbstractUIController {

	static final org.slf4j.Logger logger = LoggerFactory.getLogger(HomeController.class)
	/**
	 * 
	 * This is the Home page Service to retrieve the data for the home page from the database
	 */

	@Autowired
	HomePageService homePageService;

	@Autowired
	ServletContext servletContext;

	@RequestMapping(value =["/home", "/"], method = RequestMethod.GET)
	public String index(Model modelMap) {

		logger.info("Default page is loaded")

		logger.debug("Home Controller is loaded")


		Map dataMap=(Map)servletContext.getAttribute(Tradeconstants.HOME_PAGE_DATA);
		if(dataMap==null) {
			//then call the service to retrieve the data
			dataMap=homePageService.homePageData();
			servletContext.setAttribute(Tradeconstants.HOME_PAGE_DATA, dataMap);
		}

		else {
			logger.info("Data got from servlet context. This is a cached version");
		}
		modelMap.addAttribute(Tradeconstants.BANNER_KEY, dataMap.get(Tradeconstants.BANNER_KEY));

		//This is the index file in the templates folder
		return "index";
	}
}
