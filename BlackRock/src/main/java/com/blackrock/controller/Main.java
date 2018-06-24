/**
 * 
 */
package com.blackrock.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author jatin
 *
 */
@Configuration
@ComponentScan(basePackages = { "com.blackrock" }, excludeFilters = {
		@Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class) })
@EnableJpaRepositories(basePackages = "com.blackrock.entity")
@SpringBootApplication
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.setProperty("server.port", "8090");
		SpringApplication.run(Main.class, args);

	}

}
