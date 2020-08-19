package com.devin.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.ResourceBundle;

@Configuration
//<!--load external properties-->
@PropertySource("classPath:jdbc.properties")
public class ConfigDao {

    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

//      <!--dataSource-->
    @Bean("dataSource")
    public DataSource getDataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(driver);
        dataSource.setJdbcUrl(url);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        return dataSource;
    }

//     <!--SqlSessionFactoryBean-->
    @Bean("SqlSessionFactoryBean")
    public SqlSessionFactoryBean getSqlSessionFactory() throws PropertyVetoException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(this.getDataSource());
        Resource bundle = (Resource)ResourceBundle.getBundle("classPath:sqlMapConfig.xml");
        sqlSessionFactoryBean.setMapperLocations(bundle);
        sqlSessionFactoryBean.setTypeAliasesPackage("com.devin.domain");
        return sqlSessionFactoryBean;
    }

//    <!--MapScannerConfigure-->
    @Bean("MapperScannerConfigurer")
    public MapperScannerConfigurer getMapScannerConfigure(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.devin.dao");
        return mapperScannerConfigurer;
    }
}
