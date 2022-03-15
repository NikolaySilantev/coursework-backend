package com.example.coursework.services;

import com.example.coursework.dao.ReviewSearchDao;
import com.example.coursework.models.*;
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
    private ReviewSearchDao reviewSearchDao;

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
        return reviewRepository.findAllByTagsContains(tagService.findTag(tagName));
    }

    public Review findById (Long id) {
        return reviewRepository.findById(id).get();
    }

    public boolean checkReviewAuthor (Review review, String username) {
        Review reviewFromDb = reviewRepository.findById(review.getId()).get();
        if (reviewFromDb.getUser().getUsername().equals(username)
                ||  userService.loadUserByUsername(username).getRoles().contains(new Role(ERole.ROLE_ADMIN))) {
            review.setUser(reviewFromDb.getUser());
            return true;
        }
        return false;
    }

    public String editReview (Review review, String username) {
        if (checkReviewAuthor(review, username))
        {
            review.setTags(tagService.saveTags(review.getTags()));
            imageService.editImages(review);
            reviewRepository.save(review);
            return "Review edited successfully";
        }
        return "You don't have permission to edit or the review was deleted";
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

    public List<Review> searchReview (String text) {
        return reviewSearchDao.searchReviews(text);
    }
}
