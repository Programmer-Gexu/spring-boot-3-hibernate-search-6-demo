package com.example.springboot3hibernatesearch6demo.config;

import com.example.springboot3hibernatesearch6demo.repositroy.SearchRepositoryImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @describe:
 * @author: gexu
 * @create_date: 2023/7/24 10:25
 * @version: 1.0
 **/
@Configuration
@EnableJpaRepositories(
    repositoryBaseClass = SearchRepositoryImpl.class,
    basePackages = "com.example.springboot3hibernatesearch6demo.repositroy")
public class ApplicationConfiguration {

}
