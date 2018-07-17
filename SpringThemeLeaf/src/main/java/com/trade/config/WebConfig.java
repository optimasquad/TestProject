/**
 * 
 */
package com.trade.config;

import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

/**
 * @author jatin
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.trade.controller")
public class WebConfig extends WebMvcConfigurerAdapter {

	static final org.slf4j.Logger logger = LoggerFactory.getLogger(WebMvcConfigurerAdapter.class.getName());
	private static final String TEMPLATE_RESOLVER_PREFIX = "/WEB-INF/templates/";
	private static final String TEMPLATE_RESOLVER_SUFFIX = ".html";
	private static final String TEMPLATE_RESOLVER_TEMPLATE_MODE = "HTML5";

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		logger.info("addResourceHandlers");
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");

		/*.setCacheControl(CacheControl.maxAge(1, TimeUnit.HOURS).cachePublic()).resourceChain(true)
				.addResolver(new WebJarsResourceResolver());*/

	}

	@Bean
	public ViewResolver viewResolver() {
		logger.info("viewResolver");
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(templateEngine());
		viewResolver.setCache(false);
		viewResolver.setCacheLimit(0);
		return viewResolver;
	}

	@Bean
	public SpringTemplateEngine templateEngine() {
		logger.info("templateEngine");
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(templateResolver());
		return templateEngine;
	}

	@Bean
	public TemplateResolver templateResolver() {
		logger.info("viewResolver");
		TemplateResolver templateResolver = new ServletContextTemplateResolver();
		templateResolver.setPrefix(TEMPLATE_RESOLVER_PREFIX);
		templateResolver.setSuffix(TEMPLATE_RESOLVER_SUFFIX);
		templateResolver.setTemplateMode(TEMPLATE_RESOLVER_TEMPLATE_MODE);
		templateResolver.setCacheable(false);
		templateResolver.setCacheTTLMs(0l);
		return templateResolver;
	}

}