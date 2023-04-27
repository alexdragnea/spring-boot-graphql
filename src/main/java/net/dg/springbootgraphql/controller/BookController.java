package net.dg.springbootgraphql.controller;

import lombok.AllArgsConstructor;
import net.dg.springbootgraphql.entity.Book;
import net.dg.springbootgraphql.service.impl.BookServiceImpl;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class BookController {

  private final BookServiceImpl bookService;

  @QueryMapping
  public List<Book> findAllBooks() {
    return bookService.getAllBooks();
  }

  @MutationMapping
  public Book createBook(@Argument String title, @Argument Integer pages, @Argument String author) {

    return bookService.createBook(title, pages, author);
  }

  @QueryMapping
  public Book getBookById(@Argument Integer id) {
    return bookService.getBookById(id);
  }

  @MutationMapping
  public Book deleteBookById(@Argument Integer id) {
    return bookService.deleteBookById(id);
  }
}
