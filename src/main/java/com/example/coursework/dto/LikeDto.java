package com.example.coursework.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LikeDto {
    private Long userId;
    private Long reviewId;

    public LikeDto(Long userId, Long reviewId) {
        this.userId = userId;
        this.reviewId = reviewId;
    }
}
