package com.example.coursework.dto;

import lombok.Data;

import java.util.Set;

@Data
public class UserProfileDto {
    private String email;
    private String imageUrl;
    private Set<UserReviewDto> reviews;

    public UserProfileDto(String email, String imageUrl, Set<UserReviewDto> reviews) {
        this.email = email;
        this.imageUrl = imageUrl;
        this.reviews = reviews;
    }
}
