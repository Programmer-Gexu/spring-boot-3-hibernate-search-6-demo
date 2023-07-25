package com.example.springboot3hibernatesearch6demo.service;

import com.example.springboot3hibernatesearch6demo.model.Plant;
import com.example.springboot3hibernatesearch6demo.repository.PlantRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlantService {

  private final PlantRepository plantRepository;

  private static final List<String> SEARCHABLE_FIELDS = List.of("name", "scientificName", "family");

  @Autowired
  public PlantService(PlantRepository plantRepository) {

    this.plantRepository = plantRepository;
  }

  public List<Plant> searchPlants(String text, List<String> fields, int limit) throws Exception {

    final var fieldsToSearchBy = fields.isEmpty() ? SEARCHABLE_FIELDS : fields;

    final var containsInvalidField = fieldsToSearchBy.stream()
        .anyMatch(f -> !SEARCHABLE_FIELDS.contains(f));

    if (containsInvalidField) {
      throw new Exception("索引错误!");
    }

    return plantRepository.searchBy(
        text, limit, fieldsToSearchBy.toArray(new String[0]));
  }
}
