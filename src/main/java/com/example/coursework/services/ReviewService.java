package com.example.coursework.services;

import com.example.coursework.models.Review;
import com.example.coursework.models.Tag;
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

    @Autowired
    private TagService tagService;

    public List<Review> findAll () {
        return reviewRepository.findAll();
    }

    public List<Review> findAllByTag (String tagName) {
        //tagService.findTag(tagName);
        return reviewRepository.findAllByTagsContains(tagService.findTag(tagName));
    }

    public Review findById (Long id) {
        return reviewRepository.findById(id).get();
    }

    public String saveReview (Review review, String username) {
        if (review != null) {
            review.setTags(tagService.saveTags(review.getTags()));
            review.setUser(userService.loadUserByUsername(username));
            review.setId(reviewRepository.save(review).getId());
            imageService.saveImages(review);
            return "Review added successfully";
        }
        else return "Something went wrong. Your review has not been saved.";
    }
}
