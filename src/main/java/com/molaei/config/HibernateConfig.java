package com.molaei.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.dialect.MySQL55Dialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@PropertySource("classpath:database.properties")
@EnableTransactionManagement
public class HibernateConfig {

    //for connecting to properties file (it's from spring)
    @Autowired
    Environment env;

    @Bean
    @Autowired
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource){
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setPackagesToScan("com.molaei.data.entities");
        factoryBean.setHibernateProperties(hibernateProperties());
        return factoryBean;
    }

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getRequiredProperty("database.datasource.driver"));
        dataSource.setUrl(env.getRequiredProperty("database.datasource.url"));
        dataSource.setUsername(env.getRequiredProperty("database.datasource.username"));
        dataSource.setPassword(env.getRequiredProperty("database.datasource.password"));
        return dataSource;
    }

    private Properties hibernateProperties(){
        Properties prop = new Properties();
        prop.put(AvailableSettings.SHOW_SQL, "true");
        prop.put(AvailableSettings.FORMAT_SQL, "true");
        prop.put(AvailableSettings.DIALECT, "org.hibernate.dialect.MySQL55Dialect");
        prop.put(AvailableSettings.HBM2DDL_AUTO, "update");
        return prop;
    }

    @Bean
    @Autowired
    public PlatformTransactionManager platformTransactionManager(SessionFactory sessionFactory){
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory);
        return transactionManager;
    }
}
