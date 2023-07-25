package com.example.springboot3hibernatesearch6demo.config;

import com.example.springboot3hibernatesearch6demo.repository.SearchRepositoryImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(
    repositoryBaseClass = SearchRepositoryImpl.class,
    basePackages = "com.example.springboot3hibernatesearch6demo.repository")
public class ApplicationConfiguration {

}
