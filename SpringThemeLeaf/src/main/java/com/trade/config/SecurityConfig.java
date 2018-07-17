/**
 * 
 */
package com.trade.config;

/**
 * @author jatin
 *
 */
import javax.sql.DataSource;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	static final org.slf4j.Logger logger = LoggerFactory.getLogger(SecurityConfig.class.getName());

	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		logger.info("configure for http");
		http.authorizeRequests()
				.antMatchers("/resources/**", "/register/**", "/doRegister/**", "/product/**", "/home/**", "/",
						"/customer/registration/**", "/customer/submitregistration/**", "/misc/**",
						"/customer/forgotpassword/**", "/api/**", "/common/**", "/deals/**", "/logout/**",
						"/redeems/**")
				.permitAll().antMatchers("/admin/**").hasRole("ADMIN").anyRequest().hasRole("USER").and().formLogin()
				.loginPage("/login").defaultSuccessUrl("/home").failureUrl("/loginerror").permitAll().and().logout()
				.logoutSuccessUrl("/home").and().httpBasic();

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		logger.info("configure");
		auth.jdbcAuthentication().dataSource(dataSource);
	}
}