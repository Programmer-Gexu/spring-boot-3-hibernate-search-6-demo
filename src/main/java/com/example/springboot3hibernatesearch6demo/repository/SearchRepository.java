package com.example.springboot3hibernatesearch6demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface SearchRepository<T, ID> extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {

  List<T> searchBy(String text, int limit, String... fields);
}
