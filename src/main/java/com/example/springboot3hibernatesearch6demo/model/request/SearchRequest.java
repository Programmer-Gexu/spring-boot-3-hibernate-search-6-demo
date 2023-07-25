package com.example.springboot3hibernatesearch6demo.model.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class SearchRequest {

  @NotBlank
  private String text;

  private List<String> fields = new ArrayList<>();

  @Min(1)
  private int limit;
}
