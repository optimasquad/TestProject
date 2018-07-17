package com.kenan.rest.controller;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kenan.rest.model.Response;
import com.kenan.rest.model.Result;
import com.kenan.rest.service.RestService;

@Controller
public class HomeController {

	RestService restService = new RestService();

	static final org.slf4j.Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = { "", "/", "/index", "/home" })
	public String index(Model model) {
		logger.info("Default page is loaded");
		// then call the service to retrieve the data
		Response response = restService.consumeService();
		Result result = response.getRestResponse().getResult();
		model.addAttribute("COUNTRY", result.getCountry());
		model.addAttribute("CITY", result.getLargestCity());
		return "index/index";

	}

}
