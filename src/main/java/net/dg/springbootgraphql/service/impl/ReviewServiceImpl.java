package net.dg.springbootgraphql.service.impl;

import lombok.AllArgsConstructor;
import net.dg.springbootgraphql.entity.Review;
import net.dg.springbootgraphql.repository.ReviewRepository;
import net.dg.springbootgraphql.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ReviewServiceImpl implements ReviewService {

  private final ReviewRepository reviewRepository;

  @Override
  public List<Review> getAllReviews() {
    return reviewRepository.findAll();
  }

  @Override
  public Review getReviewById(Integer id) {
    return reviewRepository
        .findById(id)
        .orElseThrow(() -> new RuntimeException("Review with id " + id + " not found"));
  }

  @Override
  public Review createReview(String title, String comment) {
    Review review = new Review(title, comment);
    return reviewRepository.save(review);
  }

  @Override
  public Review deleteReviewById(Integer id) {
    Review review =
        reviewRepository
            .findReviewById(id)
            .orElseThrow(() -> new RuntimeException("Review with id " + id + " not found"));
    reviewRepository.deleteById(id);
    return review;
  }
}
