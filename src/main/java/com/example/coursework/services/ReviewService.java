package com.example.coursework.services;

import com.example.coursework.models.Review;
import com.example.coursework.models.User;
import com.example.coursework.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ImageService imageService;

    public List<Review> findAll () {
        return reviewRepository.findAll();
    }

    public Review findById (Long id) {
        return reviewRepository.findById(id).get();
    }

    public String saveReview (Review review, String username) {
        if (review != null) {
            review.setUser(userService.loadUserByUsername(username));
            review.setId(reviewRepository.save(review).getId());
            imageService.saveImages(review);
            return "Review added successfully";
        }
        else return "Something went wrong. Your review has not been saved.";
    }
}
