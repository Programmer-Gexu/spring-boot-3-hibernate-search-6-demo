package com.example.springboot3hibernatesearch6demo.controller;

import com.example.springboot3hibernatesearch6demo.model.Plant;
import com.example.springboot3hibernatesearch6demo.model.request.SearchRequest;
import com.example.springboot3hibernatesearch6demo.service.PlantService;
import java.util.List;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/plant")
public class PlantController {

  private final PlantService plantService;

  @Autowired
  public PlantController(PlantService plantService) {

    this.plantService = plantService;
  }

  @GetMapping("/search")
  @SneakyThrows
  public List<Plant> searchPlants(SearchRequest searchRequest) {

    return plantService.searchPlants(searchRequest.getText(), searchRequest.getFields(),
        searchRequest.getLimit());
  }
}
