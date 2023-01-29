package com.harsh.projects.dto;

import io.micronaut.core.annotation.Introspected;
import java.util.UUID;
import lombok.Data;

@Data
@Introspected
public class BookDTO {
  private UUID uid;
  private String title;
  private String isbn;
  private String author;
  private String publisher;
  private Long genreId;
}
