package net.dg.springbootgraphql.service.impl;

import lombok.AllArgsConstructor;
import net.dg.springbootgraphql.entity.Book;
import net.dg.springbootgraphql.repository.BookRepository;
import net.dg.springbootgraphql.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

  private final BookRepository bookRepository;

  @Override
  public List<Book> getAllBooks() {
    return bookRepository.findAll();
  }

  @Override
  public Book getBookById(Integer id) {
    return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book with id " + id + " not found"));
  }

  @Override
  public Book createBook(String title, Integer pages, String author) {
    return bookRepository.save(new Book(title, pages, author));
  }

  @Override
  public Book deleteBookById(Integer id) {

    Book book =
        bookRepository
            .findBookById(id)
            .orElseThrow(() -> new RuntimeException("Book with id " + id + " not found"));

    bookRepository.deleteById(id);
    return book;
  }
}
