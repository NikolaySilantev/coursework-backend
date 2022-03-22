package com.example.coursework.dto;

import lombok.Data;

import java.util.Set;

@Data
public class UserReviewDto {
    private Long id;
    private String categoryName;
    private String title;
    private String full_text;
    private Set<String> imageUrls;

    public UserReviewDto(Long id, String categoryName, String title, String full_text, Set<String> imageUrls) {
        this.id = id;
        this.categoryName = categoryName;
        this.title = title;
        this.full_text = full_text;
        this.imageUrls = imageUrls;
    }
}
