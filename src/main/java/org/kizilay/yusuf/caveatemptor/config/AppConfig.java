package org.kizilay.yusuf.caveatemptor.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaAuditing
public class AppConfig {

    @Autowired
    private DataSource dataSource;
    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setPackagesToScan("org.kizilay.yusuf");
        sessionFactory.setHibernateProperties(hibernateProperties());

        return sessionFactory;
    }

    @Bean
    public PlatformTransactionManager hibernateTransactionManager() {
        HibernateTransactionManager transactionManager
                = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }

    private final Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty(
                "hibernate.hbm2ddl.auto", "create-drop");
        hibernateProperties.setProperty(
                "hibernate.dialect", "org.hibernate.dialect.PostgreSQL10Dialect");
       //hibernateProperties.setProperty("hibernate.show_sql","true");
       // hibernateProperties.setProperty("hibernate.cache.use_second_level_cache","true");
        //hibernateProperties.setProperty("hibernate.cache.use_query_cache","true");
        hibernateProperties.setProperty("hibernate.cache.region.factory_class","org.hibernate.cache.ehcache.EhCacheRegionFactory");
        hibernateProperties.setProperty("hibernate.format_sql","true");
        hibernateProperties.setProperty("hibernate.current_session_context_class","org.springframework.orm.hibernate5.SpringSessionContext");
        //hibernateProperties.setProperty("hibernate.current_session_context_class","jta");

        return hibernateProperties;
    }
}
