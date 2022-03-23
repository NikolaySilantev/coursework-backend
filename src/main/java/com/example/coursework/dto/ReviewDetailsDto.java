package com.example.coursework.dto;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Set;

@Data
public class ReviewDetailsDto {
    private String title;
    private String category;
    private String full_text;
    private Set<String> imageUrls;
    private Double authorScore;
    private Double userScore;
    private Integer likeCount;
    private Timestamp releaseDate;
    private String authorName;
    private String authorImgUrl;
    private Set<String> tags;

    public ReviewDetailsDto(String title, String category, String full_text, Set<String> imageUrls, Double authorScore, Double userScore, Integer likeCount, Timestamp releaseDate, String authorName, String authorImgUrl, Set<String> tags) {
        this.title = title;
        this.category = category;
        this.full_text = full_text;
        this.imageUrls = imageUrls;
        this.authorScore = authorScore;
        this.userScore = userScore;
        this.likeCount = likeCount;
        this.releaseDate = releaseDate;
        this.authorName = authorName;
        this.authorImgUrl = authorImgUrl;
        this.tags = tags;
    }
}
