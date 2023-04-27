package net.dg.springbootgraphql.service;

import net.dg.springbootgraphql.entity.Book;

import java.util.List;

public interface BookService {

  List<Book> getAllBooks();

  Book getBookById(Integer id);

  Book createBook(String title, Integer pages, String author);

  Book deleteBookById(Integer id);
}
