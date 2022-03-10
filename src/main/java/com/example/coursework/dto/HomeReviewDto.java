package com.example.coursework.dto;

import lombok.Data;

import java.util.Set;

@Data
public class HomeReviewDto {
    private Long id;
    private String title;
    private String subject;
    private String full_text;
    private String authorName;
    private String authorImgUrl;
    private Set<String> tags;

    public HomeReviewDto(Long id, String title, String subject, String full_text, String authorName, String authorImgUrl, Set<String> tags) {
        this.id = id;
        this.title = title;
        this.subject = subject;
        this.full_text = full_text;
        this.authorName = authorName;
        this.authorImgUrl = authorImgUrl;
        this.tags = tags;
    }
}
