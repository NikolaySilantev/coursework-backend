package com.example.coursework.repository;

import com.example.coursework.models.Review;
import com.example.coursework.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

public interface ReviewRepository extends JpaRepository <Review, Long> {
    Optional<Set<Review>> findAllByUser (User user);
}
