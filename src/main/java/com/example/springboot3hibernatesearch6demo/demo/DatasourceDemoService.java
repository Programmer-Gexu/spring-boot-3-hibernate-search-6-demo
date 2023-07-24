package com.example.springboot3hibernatesearch6demo.demo;

import com.example.springboot3hibernatesearch6demo.model.Plant;
import com.example.springboot3hibernatesearch6demo.repository.PlantRepository;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @describe:
 * @author: gexu
 * @create_date: 2023/7/24 10:42
 * @version: 1.0
 **/
@Service
@Slf4j
public class DatasourceDemoService implements DemoService {

  private final PlantRepository plantRepository;

  @Autowired
  public DatasourceDemoService(PlantRepository plantRepository) {

    this.plantRepository = plantRepository;
  }

  @Override
  public void run() {

    final var plants = List.of(
        new Plant("subalpine fir", "abies lasiocarpa", "pinaceae"),
        new Plant("sour cherry", "prunus cerasus", "rosaceae"),
        new Plant("asian pear", "pyrus pyrifolia", "rosaceae"),
        new Plant("chinese witch hazel", "hamamelis mollis", "hamamelidaceae"),
        new Plant("silver maple", "acer saccharinum", "sapindaceae"),
        new Plant("cucumber tree", "magnolia acuminata", "magnoliaceae"),
        new Plant("korean rhododendron", "rhododendron mucronulatum", "ericaceae"),
        new Plant("water lettuce", "pistia", "araceae"),
        new Plant("sessile oak", "quercus petraea", "fagaceae"),
        new Plant("common fig", "ficus carica", "moraceae")
    );
    plantRepository.saveAll(plants);
  }
}
