package com.harsh.projects.dao;

import io.micronaut.serde.annotation.Serdeable;
import java.util.Objects;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

@Getter
@Setter
@ToString
@Entity
@Serdeable
@Table(name = "book")
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "uid", nullable = false)
  private UUID uid;

  @Column(name = "title", nullable = false, unique = true, columnDefinition = "TEXT")
  private String title;

  @Column(name = "isbn", nullable = false, unique = true)
  private String isbn;

  @Column(name = "description", nullable = true, columnDefinition = "TEXT")
  private String description;

  @Column(name = "author", nullable = true, columnDefinition = "TEXT")
  private String author;

  @Column(name = "publisher", nullable = true, columnDefinition = "TEXT")
  private String publisher;

  @ManyToOne(cascade = CascadeType.REMOVE, optional = false)
  @JoinColumn(name = "genre_id", nullable = false)
  private Genre genre;

  public Book(
      @NotNull String isbn,
      @NotNull String name,
      @NotNull String description,
      @NotNull String author,
      @NotNull String publisher,
      Genre genre) {
    this.isbn = isbn;
    this.title = name;
    this.description = description;
    this.author = author;
    this.publisher = publisher;
    this.genre = genre;
  }

  public Book() {
  }

  public UUID getUID() {
    return uid;
  }

  public void setUID(UUID uid) {
    this.uid = uid;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public Genre getGenre() {
    return genre;
  }

  public void setGenre(Genre genre) {
    this.genre = genre;
  }

  @Override
  public String toString() {
    return "Book{" +
        "id=" + uid.toString() +
        ", title='" + title + '\'' +
        ", isbn='" + isbn + '\'' +
        ", description='" + description + '\'' +
        ", author='" + author + '\'' +
        ", published_by='" + publisher + '\'' +
        ", genre=" + genre.toString() +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }
    Book book = (Book) o;
    return uid != null && Objects.equals(uid, book.uid);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
