/**
 * 
 */
package com.trade.config;

import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author jatin
 *
 */
@Configuration
@ComponentScan(basePackages = { "com.trade" }, excludeFilters = {
		@Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class) })
@EnableJpaRepositories(basePackages = "com.trade.repository")
@EnableTransactionManagement
public class WebRootConfig {

	static final org.slf4j.Logger logger = LoggerFactory.getLogger(WebRootConfig.class.getName());

	@Bean
	public BasicDataSource dataSource() {

		logger.info("dataSource");

		BasicDataSource bds = new BasicDataSource();

		bds.setDriverClassName("com.mysql.jdbc.Driver");
		bds.setUrl("jdbc:mysql://localhost:3306/ecommerce");
		bds.setUsername("root");
		bds.setPassword("root");
		bds.setInitialSize(10);
		bds.setMaxTotal(500);

		return bds;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		logger.info("entityManagerFactory");
		LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
		emfb.setDataSource(dataSource());
		emfb.setJpaVendorAdapter(jpaVendorAdapter());
		emfb.setPackagesToScan("com.trade.entity");
		emfb.setJpaProperties(additionalProperties());
		return emfb;
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		logger.info("transactionManager");
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

		return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	@Bean
	public PersistenceAnnotationBeanPostProcessor paPostProcessor() {
		return new PersistenceAnnotationBeanPostProcessor();
	}

	Properties additionalProperties() {
		Properties properties = new Properties();
		// properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		return properties;
	}

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		logger.info("transactionManager");

		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabasePlatform("MYSQL");
		adapter.setShowSql(true);
		// adapter.setGenerateDdl(true);
		return adapter;
	}

	// Mail bean

	@Bean
	public JavaMailSender javaMailService() {
		logger.info("javaMailService");
		JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
		javaMailSender.setHost("smtp.gmail.com");
		javaMailSender.setPort(465);
		javaMailSender.setUsername("jmahajan165@gmail.com");
		javaMailSender.setPassword("sg2485@1958");
		javaMailSender.setJavaMailProperties(getMailProperties());
		return javaMailSender;
	}

	private Properties getMailProperties() {
		logger.info("javaMailServiceProperties");
		Properties properties = new Properties();
		properties.setProperty("mail.transport.protocol", "smtp");
		properties.setProperty("mail.smtp.auth", "true");
		properties.setProperty("mail.smtp.starttls.enable", "true");
		properties.setProperty("mail.smtps.ssl.checkserveridentity", "false");
		properties.setProperty("mail.smtps.ssl.trust", "*");
		properties.setProperty("mail.debug", "true");
		properties.setProperty("mail.smtp.socketFactory.port", "465");
		properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		properties.setProperty("mail.smtp.socketFactory.fallback", "false");
		//properties.setProperty("mail.smtp.ssl.enable", "true");

		/*
		 * * spring.mail.host=your.smtp.com spring.mail.port=587
		 * spring.mail.username=test spring.mail.password=test
		 * spring.mail.properties.mail.smtp.auth=true
		 * spring.mail.properties.mail.smtp.starttls.enable=true
		 * spring.mail.properties.mail.smtp.starttls.required=true
		 */

		return properties;
	}

}
