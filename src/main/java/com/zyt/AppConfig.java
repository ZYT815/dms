package com.zyt;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@ComponentScan
@PropertySource("classpath:db.properties")
@ImportResource("classpath:applicationContext.xml")
public class AppConfig {
	
	@Autowired
	private Environment environment;
	
	@Bean
	public DataSource dataSource(){
		DruidDataSource dataSource=new DruidDataSource();
		dataSource.setUsername(environment.getProperty(Const.Props.JDBC.USERNAME));
		dataSource.setPassword(environment.getProperty(Const.Props.JDBC.PASS));
		dataSource.setUrl(environment.getProperty(Const.Props.JDBC.URL));
		dataSource.setDriverClassName(com.mysql.jdbc.Driver.class.getName());
		return dataSource;
	}
	
	@Bean
	public PlatformTransactionManager hibernateTransactionManager(SessionFactory sessionFactory){
		HibernateTransactionManager hibernateTransactionManager=new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(sessionFactory);
		return hibernateTransactionManager;
	}
	
	@Bean
	public SessionFactory sessionFactory(DataSource dataSource) throws IOException{
		Properties props=new Properties();
        props.setProperty(Const.Props.DIALECT, org.hibernate.dialect.MySQLDialect.class.getName());
		
		LocalSessionFactoryBean localSessionFactoryBean=new LocalSessionFactoryBean();
		localSessionFactoryBean.setDataSource(dataSource);
		localSessionFactoryBean.setPackagesToScan(Const.PackageName.ENTITY);
		localSessionFactoryBean.setHibernateProperties(props);
		localSessionFactoryBean.afterPropertiesSet();
		
		return localSessionFactoryBean.getObject();
	}
	
}
