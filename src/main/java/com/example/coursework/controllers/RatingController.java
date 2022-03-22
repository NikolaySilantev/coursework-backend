package com.example.coursework.controllers;

import com.example.coursework.dto.LikeDto;
import com.example.coursework.dto.ScoreDto;
import com.example.coursework.mappers.RatingMapper;
import com.example.coursework.payload.response.MessageResponse;
import com.example.coursework.services.RatingService;
import com.example.coursework.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

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
        return ratingService.getUserScore(reviewId, userId).getScore();
    }

    @PostMapping("/like")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> likeReview(@RequestBody LikeDto likeDto) {
        return ResponseEntity.ok(new MessageResponse(
                ratingService.likeReview(ratingMapper.likeDtoToLike(likeDto))));
    }

    @PostMapping("/rate")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> rateReviewSubject(@RequestBody ScoreDto scoreDto) {
        String message = ratingService.scoreReviewSubject(ratingMapper.scoreDtoToScore(scoreDto));
        reviewService.updateAvgScore(scoreDto.getReviewId());
        return ResponseEntity.ok(new MessageResponse(message));
    }
}
