package com.example.coursework.services;

import com.example.coursework.models.Like;
import com.example.coursework.models.Review;
import com.example.coursework.models.Score;
import com.example.coursework.repository.LikeRepository;
import com.example.coursework.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingService {

    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private ScoreRepository scoreRepository;

    public String likeReview(Like like) {
        likeRepository.findLikeByUserAndReview(like.getUser(), like.getReview()).ifPresentOrElse((value) -> {
            likeRepository.delete(value);
        }, () -> {
            likeRepository.save(like);
        });
        return "Completed";
    }

    public String scoreReviewSubject(Score score) {
        scoreRepository.findScoreByUserAndReview(score.getUser(), score.getReview()).ifPresentOrElse((scoreFromDb) -> {
            score.setId(scoreFromDb.getId());
            scoreRepository.save(score);
        }, () -> {
            scoreRepository.save(score);
        });
        return "Completed";
    }

    public Integer getLikeCount(Long reviewId) {
        return likeRepository.countAllByReviewId(reviewId);
    }

    public Integer getUserLikeCount(Long userId, Long reviewId) {
        return likeRepository.countAllByReviewId(reviewId);
    }

    public Double getAvgScore(Long reviewId) {
        return scoreRepository.avgScoreByReviewId(reviewId);
    }
    public Score getUserScore(Long reviewId, Long userId) {
        return scoreRepository.findScoreByUserIdAndReviewId(reviewId, userId).orElse(new Score(0f));
    }

    public Boolean getUserLike(Long reviewId, Long userId) {
        return likeRepository.findLikeByUserIdAndReviewId(reviewId, userId).isPresent();
    }
}
