package com.blackrock.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.blackrock.entity.Cusp;
import com.blackrock.entity.User;
import com.blackrock.service.PortfolioService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({ "/api" })
public class PortfolioController {

	@Autowired
	private PortfolioService portfolioService;

	@GetMapping
	public List<User> getAllDetails() throws JsonProcessingException {
		System.out.println("Hello World");
		List<String> results = portfolioService.getAllResults();
		List<User> userList = null;
		if (results == null) {

			results = new ArrayList<String>();
			userList = new ArrayList<User>();
		}
		User user = new User();
		user.setId("1");
		user.setFirstName("jatin");
		user.setLastName("mahajan");
		user.setEmail("jmahajan165@gmail.com");
		userList.add(user);

		results.add("1");
		results.add("jatin");
		results.add("mahajan");
		results.add("test@yahoo.com");

		ObjectMapper mapperObj = new ObjectMapper();
		String output = mapperObj.writeValueAsString(userList);
		System.out.println(output);
		return userList;

	}

	@RequestMapping(path = "/cusp/{portfolio}/{date}/{openDate}", method = RequestMethod.GET)
	public List<Cusp> getAllCusipDetails(@PathVariable String portfolio, @PathVariable String date,
			@PathVariable String openDate) throws JsonProcessingException {
		System.out.println("Hello Cusps");
		System.out.println("The Portfolio Group Name is " + portfolio);
		System.out.println("The Portfolio Date is " + date);
		System.out.println("The Portfolio Open Date is " + openDate);
		Cusp cusp = new Cusp();
		List<Cusp> cuspList = new ArrayList<Cusp>();
		Cusp cusp1 = new Cusp();
		Cusp cusp2 = new Cusp();
		Cusp cusp3 = new Cusp();
		Cusp cusp4 = new Cusp();
		Cusp cusp5 = new Cusp();

		cusp.setId("1hvjhvh");
		cusp1.setId("jkkjnkjnn1");
		cusp2.setId("ljnlnjlk8951");
		cusp3.setId("hbbhjvjhb7541452");
		cusp4.setId("jhbjhvhjvjyh5178455");
		cusp5.setId("48451548494");
		cuspList.add(cusp);
		cuspList.add(cusp1);
		cuspList.add(cusp2);
		cuspList.add(cusp3);
		cuspList.add(cusp4);
		cuspList.add(cusp5);
		return cuspList;

	}

}
