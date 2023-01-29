package com.harsh.projects.repository;


import com.harsh.projects.dao.Genre;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;
import javax.validation.constraints.NotNull;

public interface GenreRepository extends CrudRepository<Genre, Long> {

  @NonNull
  @Override
  Iterable<Genre> findAll();

  @NonNull
  List<Genre> findAllOrderById();

  @NonNull
  @Override
  Optional<Genre> findById(@NotNull Long id);

  @NonNull
  List<Genre> findByName(@NotNull String name);
}
