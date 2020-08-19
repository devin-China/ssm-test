package com.devin.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
//<!--component scan-->
@ComponentScan(basePackages = "com.devin.service")
//事务注解驱动开启，使用@Transactional到方法上即可
// <!--transaction driver-->
@EnableTransactionManagement
public class ConfigService {


    //<!--transaction manager-->
    @Bean
    public  DataSourceTransactionManager getDataSourceTransactionManager(DataSource dataSource){
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }




}
