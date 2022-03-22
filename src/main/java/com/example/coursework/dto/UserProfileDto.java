package com.example.coursework.dto;

import lombok.Data;

import java.util.Set;

@Data
public class UserProfileDto {
    private String username;
    private String email;
    private String imageUrl;

    public UserProfileDto(String username, String email, String imageUrl) {
        this.username = username;
        this.email = email;
        this.imageUrl = imageUrl;
    }
}
