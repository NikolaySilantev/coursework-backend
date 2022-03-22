package com.example.coursework.dto;

import lombok.Data;

import java.util.Set;

@Data
public class ReviewAddDto {
    private String title;
    private String category;
    private String full_text;
    private Set<String> imageUrls;
    private Set<String> tags;
    private Double authorScore;

    public ReviewAddDto(String title, String category, String full_text, Set<String> imageUrls, Set<String> tags, Double authorScore) {
        this.title = title;
        this.category = category;
        this.full_text = full_text;
        this.imageUrls = imageUrls;
        this.tags = tags;
        this.authorScore = authorScore;
    }
}
