package net.dg.springbootgraphql;

import net.dg.springbootgraphql.entity.Book;
import net.dg.springbootgraphql.entity.Review;
import net.dg.springbootgraphql.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Collections;

@SpringBootApplication
public class SpringBootGraphqlApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringBootGraphqlApplication.class, args);
  }

  @Bean
  public CommandLineRunner initData(BookRepository bookRepository) {
    return args -> {
      Book book = new Book("Reactive Spring", 408,"Josh Long");
      Review review = new Review("Great book!", "I really enjoyed this book!");
      book.setReviews(Collections.singletonList(review));
      bookRepository.save(book);
    };
  }
}
