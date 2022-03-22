package com.example.coursework.services;

import com.example.coursework.dao.ReviewSearchDao;
import com.example.coursework.models.Review;
import com.example.coursework.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ReviewSearchDao reviewSearchDao;

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ImageService imageService;

    @Autowired
    private TagService tagService;

    @Autowired
    private RatingService ratingService;

    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    public List<Review> findAllByTag(String tagName) {
        return reviewRepository.findAllByTagsContains(tagService.findTag(tagName));
    }

    public Review findById(Long id) {
        return reviewRepository.findById(id).get();
    }

    public boolean checkReviewAuthor(Review review, String username) {
        Review reviewFromDb = reviewRepository.findById(review.getId()).get();
        boolean isAuthor = reviewFromDb.getUser().getUsername().equals(username);
        if (isAuthor || userService.isAdmin(username)) {
            review.setUser(reviewFromDb.getUser());
            return true;
        }
        return false;
    }

    public String editReview(Review review, String username) {
        if (checkReviewAuthor(review, username)) {
            review.setTags(tagService.saveTags(review.getTags()));
            review.setCategory(categoryService.findCategory(review.getCategory().getName()));
            imageService.editImages(review);
            reviewRepository.save(review);
            return "Review edited successfully";
        }
        return "You don't have permission to edit or the review was deleted";
    }

    public String addReview(Review review, String author, String sender) {
        if (review != null || author == sender || userService.isAdmin(sender)) {
            review.setTags(tagService.saveTags(review.getTags()));
            review.setCategory(categoryService.findCategory(review.getCategory().getName()));
            review.setReleaseDate(new Timestamp(System.currentTimeMillis()));
            review.setUser(userService.loadUserByUsername(author));
            review.setId(reviewRepository.save(review).getId());
            imageService.saveImages(review);
            return "Review added successfully";
        } else return "Something went wrong. Your review has not been saved.";
    }

    public String deleteReview(Long id, String username) {
        Review review = reviewRepository.findById(id).get();
        if (checkReviewAuthor(review, username)) {
            reviewRepository.deleteById(id);
            return "Review deleted";
        }
        return "You don't have permission to delete this";

    }

    public List<Review> searchReview(String text) {
        return reviewSearchDao.searchReviews(text);
    }

    public void updateAvgScore(Long reviewId) {
        Review review = reviewRepository.getById(reviewId);
        review.setUserScore(ratingService.getAvgScore(reviewId));
        reviewRepository.save(review);
    }
}
