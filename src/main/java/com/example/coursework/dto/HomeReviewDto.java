package com.example.coursework.dto;

import lombok.Data;

@Data
public class HomeReviewDto {
    private Long id;
    private String title;
    private String subject;
    private String full_text;

    private Long authorId;
    private String authorName;
    private String authorImgUrl;

    public HomeReviewDto(Long id, String title, String subject, String full_text, Long authorId, String authorName, String authorImgUrl) {
        this.id = id;
        this.title = title;
        this.subject = subject;
        this.full_text = full_text;
        this.authorId = authorId;
        this.authorName = authorName;
        this.authorImgUrl = authorImgUrl;
    }
}
