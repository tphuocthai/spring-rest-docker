package com.tphuocthai.rest.config;

import com.jolbox.bonecp.BoneCPDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Persistence config
 * Created by tphuocthai on 7/10/16.
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.tphuocthai.rest.repositories")
public class PersistenceConfig {
    @Autowired
    private Environment environment;

    @Bean
    public DataSource dataSource() {
        BoneCPDataSource dataSource = new BoneCPDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl(environment.getProperty("jdbc.url", "jdbc:mysql://localhost:3306/restmeasure"));
        dataSource.setUsername(environment.getProperty("jdbc.username", "root"));
        dataSource.setPassword(environment.getProperty("jdbc.password", ""));

        // Connection pooling settings
        dataSource.setIdleConnectionTestPeriodInMinutes(60);
        dataSource.setIdleMaxAgeInMinutes(240);
        dataSource.setMaxConnectionsPerPartition(30);
        dataSource.setMinConnectionsPerPartition(10);
        dataSource.setPartitionCount(3);
        dataSource.setAcquireIncrement(5);
        dataSource.setStatementsCacheSize(100);
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean emFactory = new LocalContainerEntityManagerFactoryBean();
        emFactory.setDataSource(dataSource());
        emFactory.setPackagesToScan("com.tphuocthai.rest.entity");

        emFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        emFactory.setJpaProperties(additionalProperties());

        return emFactory;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

    private Properties additionalProperties() {
        Properties properties = new Properties();
        // properties.setProperty("hibernate.show_sql", "true");
        // properties.setProperty("hibernate.format_sql", "true");
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        properties.setProperty("hibernate.ejb.naming_strategy", "org.hibernate.cfg.ImprovedNamingStrategy");
        return properties;
    }
}
