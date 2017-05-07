package com.actio.configs;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.actio.repositories.sql")
@EnableJpaAuditing
public class JpaConfiguration extends HikariConfig {

    @Value(value = "${spring.datasource.hikari.jdbc-url}")
    private String url;

    @Value(value = "${spring.datasource.hikari.username}")
    private String username;

    @Value(value = "${spring.datasource.hikari.password}")
    private String password;

    @Value(value = "${spring.datasource.hikari.data-source-class-name}")
    private String dataSourceClassName;

    @Bean
    public DataSource dataSource() {
        Properties dataSourceProperties = new Properties();
        dataSourceProperties.put("url", url);
        dataSourceProperties.put("user", username);
        dataSourceProperties.put("password", password);
        /*dataSourceProperties.put("prepStmtCacheSize",250);
        dataSourceProperties.put("prepStmtCacheSqlLimit",2048);
        dataSourceProperties.put("cachePrepStmts",Boolean.TRUE);
        dataSourceProperties.put("useServerPrepStmts",Boolean.TRUE);*/

        Properties configProperties = new Properties();
        configProperties.put("dataSourceClassName", dataSourceClassName);
        /*configProperties.put("poolName", poolName);
        configProperties.put("maximumPoolSize", maximumPoolSize);
        configProperties.put("minimumIdle", minimumIdle);
        configProperties.put("minimumIdle", minimumIdle);
        configProperties.put("connectionTimeout", connectionTimeout);
        configProperties.put("idleTimeout", idleTimeout);*/
        configProperties.put("dataSourceProperties", dataSourceProperties);

        HikariConfig hikariConfig = new HikariConfig(configProperties);
        return new HikariDataSource(hikariConfig);
    }

}