package com.example.springboot3hibernatesearch6demo.repository;

import jakarta.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;
import org.hibernate.search.engine.search.query.SearchResult;
import org.hibernate.search.mapper.orm.Search;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @describe:
 * @author: gexu
 * @create_date: 2023/7/24 10:03
 * @version: 1.0
 **/
@Transactional
public class SearchRepositoryImpl<T, ID extends Serializable>
    extends SimpleJpaRepository<T, ID>
    implements SearchRepository<T, ID> {

  private final EntityManager entityManager;

  public SearchRepositoryImpl(JpaEntityInformation<T, ?> entityInformation,
      EntityManager entityManager) {

    super(entityInformation, entityManager);
    this.entityManager = entityManager;
  }

  public SearchRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {

    super(domainClass, entityManager);
    this.entityManager = entityManager;
  }

  @Override
  public List<T> searchBy(String text, int limit, String... fields) {

    final var result = getSearchResult(text, limit, fields);
    return result.hits();
  }

  private SearchResult<T> getSearchResult(String text, int limit, String[] fields) {

    final var searchSession = Search.session(entityManager);
    return searchSession
        .search(getDomainClass())
        .where(f -> f.match().fields(fields).matching(text).fuzzy(2))
        .fetch(limit);
  }
}
