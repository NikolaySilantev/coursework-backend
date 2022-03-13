package com.example.coursework.services;

import com.example.coursework.models.Like;
import com.example.coursework.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingService {
    @Autowired
    LikeRepository likeRepository;

    public String likeReview(Like like) {
        likeRepository.findLikeByUserAndReview(like.getUser(), like.getReview()).ifPresentOrElse((value) -> {
            likeRepository.delete(value);
        }, () -> {
            likeRepository.save(like);
        });
        return "Completed";
    }
}
