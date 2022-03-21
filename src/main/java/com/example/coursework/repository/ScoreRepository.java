package com.example.coursework.repository;

import com.example.coursework.models.Like;
import com.example.coursework.models.Review;
import com.example.coursework.models.Score;
import com.example.coursework.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ScoreRepository extends JpaRepository<Score, Long> {
    Optional<Score> findScoreByUserAndReview(User user, Review review);

    Optional<Score> findScoreByUserIdAndReviewId(Long userId, Long reviewId);

    Optional<Score> findByUserUsernameAndReviewId (String username, Long reviewId);

    @Query(value = "SELECT avg(score) FROM scores where review_id=?1", nativeQuery = true)
    Double avgScoreByReviewId(Long reviewId);

    List<Score> findAllByReview(Review review);
}
