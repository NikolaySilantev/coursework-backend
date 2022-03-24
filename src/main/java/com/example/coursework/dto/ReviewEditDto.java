package com.example.coursework.dto;

import lombok.Data;

import java.util.Set;

@Data
public class ReviewEditDto {
    private Long id;
    private String title;
    private String category;
    private String full_text;
    private Double authorScore;
    private Set<String> imageUrls;
    private Set<String> tags;

    public ReviewEditDto(Long id, String title, String category, String full_text, Double authorScore, Set<String> imageUrls, Set<String> tags) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.full_text = full_text;
        this.authorScore = authorScore;
        this.imageUrls = imageUrls;
        this.tags = tags;
    }
}
