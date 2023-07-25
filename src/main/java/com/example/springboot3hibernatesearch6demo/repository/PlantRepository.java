package com.example.springboot3hibernatesearch6demo.repository;

import com.example.springboot3hibernatesearch6demo.model.Plant;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantRepository extends SearchRepository<Plant, Long> {

}
