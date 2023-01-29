package com.harsh.projects.repository;

import com.harsh.projects.dao.Book;
import com.harsh.projects.dao.Genre;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.data.annotation.Join;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;
import io.micronaut.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import javax.validation.constraints.NotNull;

public interface BookRepository extends CrudRepository<Book, UUID> {
  @NonNull
  @Join(value ="Genre", type = Join.Type.FETCH)
  Iterable<Book> findAll();

  @NonNull
  @Join(value ="Genre", type = Join.Type.FETCH)
  List<Book> findAllOrderByUidDesc();

  @NonNull
  @Join(value ="Genre", type = Join.Type.FETCH)
  List<Book> findByTitle(@NotNull String title);

  @NonNull
  @Join(value ="Genre", type = Join.Type.FETCH)
  List<Book> findByAuthor(@NotNull String author);

  @NonNull
  @Join(value ="Genre", type = Join.Type.FETCH)
  List<Book> findByGenre(@NotNull Genre genre);

  @NonNull
  @Join(value ="Genre", type = Join.Type.FETCH)
  List<Book> findByPublisher(@NotNull String publisher);

  @NonNull
  @Join(value ="Genre", type = Join.Type.FETCH)
  Optional<Book> findByIsbn(@NotNull String isbn);

}
