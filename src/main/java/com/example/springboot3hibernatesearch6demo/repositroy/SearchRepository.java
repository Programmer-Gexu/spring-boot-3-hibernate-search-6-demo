package com.example.springboot3hibernatesearch6demo.repositroy;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @describe:
 * @author: gexu
 * @create_date: 2023/7/24 10:01
 * @version: 1.0
 **/
@NoRepositoryBean
public interface SearchRepository<T, ID> extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {

  List<T> searchBy(String text, int limit, String... fields);
}
