package com.example.coursework.repository;

import com.example.coursework.models.Like;
import com.example.coursework.models.Review;
import com.example.coursework.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
    Optional<Like> findLikeByUserAndReview(User user, Review review);

    Integer countAllByReviewId (Long reviewId);

    Optional<Like> findLikeByUserIdAndReviewId(Long userId, Long reviewId);
}
