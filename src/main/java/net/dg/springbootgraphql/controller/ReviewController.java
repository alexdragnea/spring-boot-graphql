package net.dg.springbootgraphql.controller;

import lombok.AllArgsConstructor;
import net.dg.springbootgraphql.entity.Review;
import net.dg.springbootgraphql.service.impl.ReviewServiceImpl;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ReviewController {

  private final ReviewServiceImpl reviewService;

  @QueryMapping
  public List<Review> findAllReviews() {
    return reviewService.getAllReviews();
  }

  @MutationMapping
  public Review createReview(@Argument String title, @Argument String comment) {

    return reviewService.createReview(title, comment);
  }

  @QueryMapping
  public Review getReviewById(@Argument Integer id) {
    return reviewService.getReviewById(id);
  }

  @MutationMapping
  public Review deleteReviewById(@Argument Integer id) {
    return reviewService.deleteReviewById(id);
  }
}
