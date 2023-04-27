package net.dg.springbootgraphql.repository;

import net.dg.springbootgraphql.entity.Book;
import net.dg.springbootgraphql.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
    Optional<Review> findReviewById(Integer id);
}
