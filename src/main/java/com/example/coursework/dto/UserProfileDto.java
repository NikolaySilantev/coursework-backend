package com.example.coursework.dto;

import lombok.Data;

import java.util.Set;

@Data
public class UserProfileDto {
    private String username;
    private String email;
    private String imageUrl;
    private Integer rating;

    public UserProfileDto(String username, String email, String imageUrl, Integer rating) {
        this.username = username;
        this.email = email;
        this.imageUrl = imageUrl;
        this.rating = rating;
    }
}
