package net.dg.springbootgraphql.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {

  @Id @GeneratedValue private Integer id;
  private String title;
  private String comment;

  public Review(String title, String comment) {
    this.title = title;
    this.comment = comment;
  }
}
