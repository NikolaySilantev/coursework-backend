package com.example.coursework.repository;

import com.example.coursework.models.Image;
import com.example.coursework.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
    @Transactional
    @Modifying
    @Query(value = "delete from images i where i.review_id=?1", nativeQuery = true)
    void deleteAllByReviewId(Long reviewId);
}
