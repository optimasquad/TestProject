package com.aladdin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PortfolioController {

	@RequestMapping("/")
	public String test() {

		return "Hello World";
	}

}
