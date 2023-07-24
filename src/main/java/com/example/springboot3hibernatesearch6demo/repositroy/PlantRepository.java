package com.example.springboot3hibernatesearch6demo.repositroy;

import com.example.springboot3hibernatesearch6demo.model.Plant;
import org.springframework.stereotype.Repository;

/**
 * @describe:
 * @author: gexu
 * @create_date: 2023/7/24 10:23
 * @version: 1.0
 **/
@Repository
public interface PlantRepository extends SearchRepository<Plant, Long> {

}
