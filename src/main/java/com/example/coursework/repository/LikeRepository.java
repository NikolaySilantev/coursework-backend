package com.example.coursework.repository;

import com.example.coursework.models.Like;
import com.example.coursework.models.Review;
import com.example.coursework.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, Long> {
    Optional<Like> findLikeByUserAndReview (User user, Review review);
}
