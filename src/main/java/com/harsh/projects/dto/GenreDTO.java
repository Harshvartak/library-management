package com.harsh.projects.dto;

import io.micronaut.core.annotation.Introspected;
import lombok.Data;

@Data
@Introspected
public class GenreDTO {
  private long id;
  private String name;
}
