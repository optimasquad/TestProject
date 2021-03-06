package com.compliance.repo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.compliance.read.repo.repository.AbstractReadRepoImpl;
import com.compliance.read.repo.validator.AccountServiceSingleton;
import com.compliance.write.repo.service.ArticleService;
import com.compliance.write.repo.service.IArticleService;
import com.compliance.write.repo.service.IPartyService;
import com.compliance.write.repo.service.PartyService;

@Configuration
@PropertySource({ "classpath:read-db.properties" })
@EnableJpaRepositories(basePackages = "com.compliance.repo.repository", repositoryBaseClass = AbstractReadRepoImpl.class, entityManagerFactoryRef = "readEntityManagerFactory", transactionManagerRef = "readTransactionManager")
@EnableTransactionManagement
public class ReadConfig {

	@Autowired
	private Environment env;

	@Primary
	@Bean(name = "readDataSource")
	public DataSource readDataSource() {
		DriverManagerDataSource bds = new DriverManagerDataSource();
		bds.setDriverClassName("com.mysql.jdbc.Driver");
		bds.setUrl("jdbc:mysql://localhost:3306/sys");
		bds.setUsername("root");
		bds.setPassword("root");
		return bds;
	}

	@Primary
	@Bean(name = "readEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("readDataSource") DataSource dataSource) {
		Map<String, Object> properties = new HashMap<String, Object>();
		System.out.println("The value is ReadConfig " + env.getProperty("hibernate.dialect"));
		System.out.println("The value is  ReadConfig" + env.getProperty("hibernate.show_sql"));
		properties.put("org.hibernate.dialect.MySQLDialect", "org.hibernate.dialect.MySQLDialect");
		properties.put("hibernate.physical_naming_strategy", "com.compliance.repo.PhysicalNamingStrategyImpl");
		return builder.dataSource(dataSource).packages(new String[] { "com.compliance.repo.entity" })
				.persistenceUnit("shared").properties(properties).build();
	}

	@Primary
	@Bean(name = "readTransactionManager")
	public PlatformTransactionManager transactionManager(
			@Qualifier("readEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}

	@Bean
	public IArticleService articleService() {
		return new ArticleService();
	}

	@Bean
	public IPartyService partyService() {
		return new PartyService();
	}

	@Bean
	public AccountServiceSingleton accountServiceSingleton() throws NoSuchMethodException, SecurityException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		Constructor cxor = AccountServiceSingleton.class.getDeclaredConstructor();
		cxor.setAccessible(true);
		AccountServiceSingleton accountServiceSingleton = (AccountServiceSingleton) cxor.newInstance();
		accountServiceSingleton.Message();
		return accountServiceSingleton;

	}

}