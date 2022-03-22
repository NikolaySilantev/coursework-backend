package com.example.coursework.dto;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Set;

@Data
public class HomeReviewDto {
    private Long id;
    private String title;
    private String categoryName;
    private String full_text;
    private Double authorScore;
    private Double userScore;
    private Timestamp releaseDate;
    private String authorName;
    private String authorImgUrl;
    private Set<String> tags;

    public HomeReviewDto(Long id, String title, String categoryName, String full_text, Double authorScore, Double userScore, Timestamp releaseDate, String authorName, String authorImgUrl, Set<String> tags) {
        this.id = id;
        this.title = title;
        this.categoryName = categoryName;
        this.full_text = full_text;
        this.authorScore = authorScore;
        this.userScore = userScore;
        this.releaseDate = releaseDate;
        this.authorName = authorName;
        this.authorImgUrl = authorImgUrl;
        this.tags = tags;
    }
}
