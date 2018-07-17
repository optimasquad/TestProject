package com.kenan.rest.config;

/**
 * 
 */

import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	static final org.slf4j.Logger logger = LoggerFactory.getLogger(SecurityConfig.class.getName());

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		logger.info("configure for http");
		http.authorizeRequests().antMatchers("/resources/**", "/home/**", "/", "/index/**").permitAll();

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		logger.info("configure");

	}
}