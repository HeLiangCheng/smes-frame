package com.hlc.styd.smes.frame.sb.multidatasource.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * Created by Liang on 2018/11/28.
 *  多数据源配置
 *  本案例是基于spring-jpa 2.0.x版本的配置，如果使用1.5.x版本配置需要做部分修改
 */
@Configuration
public class DataSourceConfig {

    @Primary //配置该数据源为主数据源
    @Bean(name = "primaryDataSourceProperties")
    @Qualifier("primaryDataSourceProperties")
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    public DataSourceProperties primaryDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Primary //配置该数据源为主数据源
    @Bean(name = "primaryDataSource")
    @Qualifier("primaryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    public DataSource primaryDataSource() {
        return primaryDataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean(name = "secoundaryDataSourceProperties")
    @Qualifier("secoundaryDataSourceProperties")
    @ConfigurationProperties(prefix = "spring.datasource.secondary")
    public DataSourceProperties secoundaryDataSourceProperties(){
        return new DataSourceProperties();
    }

    @Bean(name = "seoncodaryDataSource")
    @Qualifier("secondaryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.secondary")
    public DataSource secoundaryDataSource() {
        return secoundaryDataSourceProperties().initializeDataSourceBuilder().build();
    }

}
