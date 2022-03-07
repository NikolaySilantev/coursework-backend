package com.example.coursework.repository;

import com.example.coursework.models.Review;
import com.example.coursework.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface ReviewRepository extends JpaRepository <Review, Long> {
    Optional<Set<Review>> findAllByUser (User user);
}
