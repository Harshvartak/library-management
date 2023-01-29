package com.harsh.projects.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.micronaut.serde.annotation.Serdeable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.ToString.Exclude;
import org.hibernate.Hibernate;

@Entity
@Getter
@Setter
@Serdeable
@Table(name = "genre")
public class Genre {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false)
  private Long id;

  @NotNull
  @Column(name = "name", nullable = false, unique = true)
  private String name;

  @JsonIgnore
  @OneToMany(mappedBy = "genre")
  @Exclude
  private Set<Book> books = new HashSet<>();

  public Genre() { /* Generic Constructor */ }

  public Genre(@NotNull String name) {
    this.name = name.trim();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(@NotNull String name) {
    this.name = name.trim();
  }

  public Set<Book> getBooks() {
    return books;
  }

  public void setBooks(Set<Book> books) {
    this.books = books;
  }

  @Override
  public String toString() {
    return "Genre{" +
        "id:" + id.toString() +
        ", name:'" + name + '\''+
        "}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }
    Genre genre = (Genre) o;
    return id != null && Objects.equals(id, genre.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
