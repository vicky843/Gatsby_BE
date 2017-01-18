package com.vicky.gatsby.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.vicky.gatsby.model.Blogdetails;
import com.vicky.gatsby.model.Persondetails;

@Configuration
@ComponentScan("com.vicky.gatsby.*")
@EnableTransactionManagement
public class Appconfig {

	@Bean(name = "dataSource")
	public DataSource getOracleDataSource() {

		DriverManagerDataSource datapart = new DriverManagerDataSource();
		datapart.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		datapart.setUrl("jdbc:oracle:thin:@//localhost:1521/XE");

		datapart.setUsername("gatsby");
		datapart.setPassword("tiger");
		System.out.println("datasource part");
		return datapart;
	}

	public Properties getHibernateProperties() {
		System.out.println("hibernatepart");
		Properties prop = new Properties();
		prop.setProperty("hibernate.hbm2ddl.auto", "update");
		prop.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		return prop;
	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClass(Persondetails.class);
		sessionBuilder.addAnnotatedClass(Blogdetails.class);
		System.out.println("sessionfactory part");
		return sessionBuilder.buildSessionFactory();
	}

	@Autowired
	@Bean(name = "transcationManager")
	public HibernateTransactionManager getTranscationManager(SessionFactory sessionfactory) {
		HibernateTransactionManager trans = new HibernateTransactionManager(sessionfactory);
		System.out.println("Transcationmanager part");
		return trans;

	}
}
