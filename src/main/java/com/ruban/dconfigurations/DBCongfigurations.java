package com.ruban.dconfigurations;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ruban.product1.Products;
@Configuration
@EnableTransactionManagement
public class DBCongfigurations {
@Bean(name="dataSource")
public DataSource getDataSource()
{
	BasicDataSource datasource=new BasicDataSource();
	datasource.setDriverClassName("org.h2.Driver");
	datasource.setUrl("jdbc:h2:tcp://localhost/~/test/ruban");
	datasource.setUsername("sa");
	datasource.setPassword("");
	System.out.println("DataSource bean"+datasource);
	return datasource;
}
@Bean
public SessionFactory sessionfactory()
{
	System.out.println("session created");
	LocalSessionFactoryBuilder lsf= new LocalSessionFactoryBuilder(getDataSource());
	Properties hiberprop = new Properties();
	hiberprop.setProperty("hibernate.dialect","org.hibernate.dialect.H2Dialect");
	hiberprop.setProperty("hibernate.hbm2ddl.auto","update");
	hiberprop.setProperty("hibernate.show_sql","true");
	lsf.addProperties(hiberprop);
	
	Class classes[]= new Class[]{Products.class};
	System.out.println("session bean"+lsf);
	return lsf.addAnnotatedClasses(classes).buildSessionFactory();
}
@Bean
public HibernateTransactionManager htman()
{
return new HibernateTransactionManager(sessionfactory());
}
}
