package com.jdbc_intro.configuration;

import com.jdbc_intro.dao.RowMapperImpl;
import com.jdbc_intro.dao.StudentDAOImpl;
import com.jdbc_intro.entities.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


@Configuration
@PropertySource("classpath:JdbcApp.properties")
public class JdbcJavaConfig {

    @Value("${driver.class.name}")
    private String driverClassName;

    @Value("${db.url}")
    private String url;

    @Value("${db.username}")
    private String username;

    @Value("${db.password}")
    private String password;


    @Bean
    public DriverManagerDataSource dataSourceBean(){
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName(driverClassName);
        driverManagerDataSource.setUrl(url);
        driverManagerDataSource.setUsername(username);
        driverManagerDataSource.setPassword(password);
        return driverManagerDataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DriverManagerDataSource dataSourceBean){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSourceBean);
        return jdbcTemplate;
    }

    @Bean
    public RowMapperImpl rowMapper(){
        return new RowMapperImpl();
    }

    @Bean
    public StudentDAOImpl studentDAOImpl(JdbcTemplate jdbcTemplate, RowMapperImpl rowMapper){
        StudentDAOImpl studentDAOImpl = new StudentDAOImpl();
        studentDAOImpl.setJdbcTemplate(jdbcTemplate);
        studentDAOImpl.setRowMapper(rowMapper);
        return studentDAOImpl;
    }

}
