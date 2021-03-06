package com.zyt;

import java.io.IOException;
import java.sql.SQLException;
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
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@ComponentScan("com.zyt")
@PropertySource("classpath:db.properties")
@ImportResource("classpath:applicationContext.xml")
public class AppConfig {

	@Autowired
	private Environment environment;

	// 数据源
	@Bean
	public DataSource dataSource() throws SQLException {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setUsername(environment.getProperty(Const.Props.JDBC.USERNAME));
		dataSource.setPassword(environment.getProperty(Const.Props.JDBC.PASS));
		dataSource.setUrl(environment.getProperty(Const.Props.JDBC.URL));
		dataSource.setDriverClassName(com.mysql.jdbc.Driver.class.getName());
		dataSource.setFilters(Const.Druid.STAT);
		return dataSource;
	}

	// hibernate事务管理器
	@Bean
	public PlatformTransactionManager hibernateTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(sessionFactory);
		return hibernateTransactionManager;
	}

	// hiberntae sessionFactory
	@Bean
	public SessionFactory sessionFactory(DataSource dataSource) throws IOException {
		Properties props = new Properties();
		props.setProperty(Const.Props.DIALECT, org.hibernate.dialect.MySQLDialect.class.getName());

		LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
		localSessionFactoryBean.setDataSource(dataSource);
		localSessionFactoryBean.setPackagesToScan(Const.PackageName.ENTITY);
		localSessionFactoryBean.setHibernateProperties(props);
		localSessionFactoryBean.afterPropertiesSet();

		return localSessionFactoryBean.getObject();
	}

	// hibernate template
	@Bean
	public HibernateTemplate hibernateTemplate(SessionFactory sessionFactory) {
		return new HibernateTemplate(sessionFactory);
	}

}
