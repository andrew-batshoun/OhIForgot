package com.organization.OhIForgot.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource("classpath:database.properties")
@EnableTransactionManagement
public class HibernateConfiguration {

	@Autowired
	private Environment env;

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(new String[] { "com.organization.OhIForgot.model" });
		sessionFactory.setHibernateProperties(hibernateProperties());

		return sessionFactory;
	}

//	@Bean
//	public DataSource dataSource() {
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName(env.getRequiredProperty("jdbc.driverClassName"));
//		dataSource.setUrl(env.getProperty("jdbc.url"));
//		dataSource.setUsername(env.getProperty("jdbc.username"));
//		dataSource.setPassword(env.getProperty("jdbc.password"));
//		return dataSource;
//	}
	
	
	@Bean
	public DataSource dataSource() {
	  return new EmbeddedDatabaseBuilder()
	    .generateUniqueName(false)
	    .setName("testdb")
	    .setType(EmbeddedDatabaseType.H2)
	    .setScriptEncoding("UTF-8")
	    .ignoreFailedDrops(true)
	    .build();
	}

	@Bean
	public HibernateTransactionManager getTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
	}

	private final Properties hibernateProperties() {
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
		hibernateProperties.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
        hibernateProperties.put("hibernate.format_sql", env.getRequiredProperty("hibernate.format_sql"));
		hibernateProperties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
		
		return hibernateProperties;
	}
}
