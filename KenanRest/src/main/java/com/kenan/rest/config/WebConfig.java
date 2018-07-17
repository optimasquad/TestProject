package com.kenan.rest.config;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 */

import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

import com.kenan.rest.model.Response;

/**
 * @author jatin
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.kenan.rest.controller")
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

	/**
	 * @return the RetTemplate Object. This method sets the marshaller object as
	 *         params to RestTemplate leveraging the marshalling capability to
	 *         the template.
	 */
	@Bean
	public RestTemplate getRestTemplate() {
		
		logger.info("restTemplate");
		RestTemplate restTemplate = new RestTemplate();

		List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>();
		converters.add(getMarshallingHttpMessageConverter());
		converters.add(new FormHttpMessageConverter());
		converters.add(new StringHttpMessageConverter());
		restTemplate.setMessageConverters(converters);
		return restTemplate;
	}
	/*
	 * @return MarshallingHttpMessageConverter object which is responsible for
	 *         marshalling and unMarshalling process
	 */
	@Bean(name = "marshallingHttpMessageConverter")
	public MarshallingHttpMessageConverter getMarshallingHttpMessageConverter() {
		logger.info("marshallingHttpMessageConverter");
		MarshallingHttpMessageConverter marshallingHttpMessageConverter = new MarshallingHttpMessageConverter();
		marshallingHttpMessageConverter.setMarshaller(getJaxb2Marshaller());
		marshallingHttpMessageConverter.setUnmarshaller(getJaxb2Marshaller());
		return marshallingHttpMessageConverter;
	}

	/**
	 * @return Jaxb2Marshaller, this is the Jaxb2Marshaller object
	 */
	@Bean(name = "jaxb2Marshaller")
	public Jaxb2Marshaller getJaxb2Marshaller() {
		logger.info("jaxb2Marshaller");
		Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
		jaxb2Marshaller.setClassesToBeBound(Response.class);
		return jaxb2Marshaller;
	}
}
