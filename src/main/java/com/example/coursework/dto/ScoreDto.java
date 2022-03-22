package com.example.coursework.dto;

import lombok.Data;

@Data
public class ScoreDto {
    private Long userId;
    private Long reviewId;
    private Double score;

    public ScoreDto(Long userId, Long reviewId, Double score) {
        this.userId = userId;
        this.reviewId = reviewId;
        this.score = score;
    }
}
