package com.example.coursework.repository;

import com.example.coursework.models.Review;
import com.example.coursework.models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findAllByTagsContains(Tag tag);
}
