package com.example.coursework.controllers;

import com.example.coursework.dto.LikeDto;
import com.example.coursework.dto.ScoreDto;
import com.example.coursework.mappers.RatingMapper;
import com.example.coursework.security.payload.response.MessageResponse;
import com.example.coursework.services.RatingService;
import com.example.coursework.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private RatingMapper ratingMapper;


    @GetMapping("/user-score")
    public Float getUserScore(@RequestParam Long reviewId, @RequestParam Long userId) {
        Float example = ratingService.getUserScore(reviewId, userId).getScore();
        return ratingService.getUserScore(reviewId, userId).getScore();
    }

    @GetMapping("/user-like")
    public Boolean getUserLike(@RequestParam Long reviewId, @RequestParam Long userId) {
        return ratingService.getUserLike(reviewId, userId);
    }

    @PostMapping("/like")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> likeReview(@Valid @RequestBody LikeDto likeDto) {
        String message = ratingService.likeReview(ratingMapper.likeDtoToLike(likeDto));
        reviewService.updateLikeCount(likeDto.getReviewId());
        return ResponseEntity.ok(new MessageResponse(message));
    }

    @PostMapping("/rate")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> rateReviewSubject(@Valid @RequestBody ScoreDto scoreDto) {
        String message = ratingService.scoreReviewSubject(ratingMapper.scoreDtoToScore(scoreDto));
        reviewService.updateAvgScore(scoreDto.getReviewId());
        return ResponseEntity.ok(new MessageResponse(message));
    }
}
