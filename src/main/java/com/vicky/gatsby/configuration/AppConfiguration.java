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

@Configuration
@ComponentScan("com.vicky")
@EnableTransactionManagement
public class AppConfiguration {
@Bean(name="dataSource")
	public DataSource getOracleDataSource(){
	
	DriverManagerDataSource dataSource=new DriverManagerDataSource();
	
	dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
	dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	dataSource.setUsername("gatsby");
	dataSource.setPassword("gatsby");
	
	return dataSource;
	}
		
	private Properties getHibernateProperties(){
		System.out.println("hibernatepart");
		Properties properties=new Properties();
	properties.put("hibernate.dialect", "org.hibernate.dialect.OracleDialect");	
	return properties;
	}
@Autowired
@Bean(name="sessionFactory")
public  SessionFactory getSessionFactory(DataSource dataSource)
{
	LocalSessionFactoryBuilder sessionBuilder=new LocalSessionFactoryBuilder(dataSource);	
	sessionBuilder.addProperties(getHibernateProperties());
		return sessionBuilder.buildSessionFactory();
}
@Autowired
@Bean(name="transcationManager")
public HibernateTransactionManager getTranscationManager(SessionFactory sessionfactory){
	HibernateTransactionManager transcationmanager= new HibernateTransactionManager(sessionfactory);
	return transcationmanager;
	
}
}

