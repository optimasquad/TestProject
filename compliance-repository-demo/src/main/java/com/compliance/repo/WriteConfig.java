package com.compliance.repo;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.compliance.write.repo.repository.AbstractWriteRepoImpl;
import com.compliance.write.repo.service.ArticleService;
import com.compliance.write.repo.service.IArticleService;
import com.compliance.write.repo.service.IPartyService;
import com.compliance.write.repo.service.PartyService;

@Configuration
@PropertySource({ "classpath:write-db.properties" })
@EnableJpaRepositories(basePackages = "com.compliance.repo.repository", repositoryBaseClass = AbstractWriteRepoImpl.class, entityManagerFactoryRef = "writeEntityManagerFactory", transactionManagerRef = "writeTransactionManager")
@EnableTransactionManagement
public class WriteConfig {

	@Autowired
	private Environment env;

	@Bean(name = "writeDataSource")
	public DataSource writeDataSource() {
		DriverManagerDataSource bds = new DriverManagerDataSource();
		bds.setDriverClassName("com.mysql.jdbc.Driver");
		bds.setUrl("jdbc:mysql://localhost:3306/sys");
		bds.setUsername("root");
		bds.setPassword("root");
		return bds;
	}

	@Bean(name = "writeEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("writeDataSource") DataSource dataSource) {
		Map<String, Object> properties = new HashMap<String, Object>();
		System.out.println("The value is WriteConfig " + env.getProperty("hibernate.dialect"));
		System.out.println("The value is  WriteConfig" + env.getProperty("hibernate.show_sql"));
		properties.put("org.hibernate.dialect.MySQLDialect", "org.hibernate.dialect.MySQLDialect");
		properties.put("hibernate.physical_naming_strategy", "com.compliance.repo.PhysicalNamingStrategyImpl");
		return builder.dataSource(dataSource).packages(new String[] { "com.compliance.repo.entity" })
				.persistenceUnit("shared").properties(properties).build();
	}

	@Bean(name = "writeTransactionManager")
	public PlatformTransactionManager transactionManager(
			@Qualifier("writeEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
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

}
