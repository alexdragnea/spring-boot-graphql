package net.dg.springbootgraphql.service;

import net.dg.springbootgraphql.entity.Review;

import java.util.List;

public interface ReviewService {

  List<Review> getAllReviews();

  Review getReviewById(Integer id);

  Review createReview(String title, String message);

  Review deleteReviewById(Integer id);
}
