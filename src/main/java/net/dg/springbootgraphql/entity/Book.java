package net.dg.springbootgraphql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String title;
  private Integer pages;
  private String author;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "book_id")
  private List<Review> reviews;

  public Book(String title, Integer pages, String author) {
    this.title = title;
    this.pages = pages;
    this.author = author;
  }
}
