package com.example.springboot3hibernatesearch6demo.config;

import jakarta.persistence.EntityManager;
import lombok.SneakyThrows;
import org.hibernate.search.mapper.orm.Search;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @describe:
 * @author: gexu
 * @create_date: 2023/7/24 10:33
 * @version: 1.0
 **/
@Transactional
@Component
public class Indexer {

  private final EntityManager entityManager;

  private static final int THREAD_NUMBER = 4;

  public Indexer(EntityManager entityManager) {

    this.entityManager = entityManager;
  }

  @SneakyThrows
  public void indexPersistedData(String indexClassName) {

    final var searchSession = Search.session(entityManager);

    final var classToIndex = Class.forName(indexClassName);
    final var indexer = searchSession
            .massIndexer(classToIndex)
            .threadsToLoadObjects(THREAD_NUMBER);

    indexer.startAndWait();
  }
}
