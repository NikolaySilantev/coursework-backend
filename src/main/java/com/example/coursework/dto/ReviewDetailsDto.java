package com.example.coursework.dto;

import lombok.Data;

import java.util.Set;

@Data
public class ReviewDetailsDto {
    private String title;
    private String subject;
    private String full_text;
    private Set<String> imageUrls;
    private String authorName;
    private String authorImgUrl;

    public ReviewDetailsDto(String title, String subject, String full_text, Set<String> imageUrls, String authorName, String authorImgUrl) {
        this.title = title;
        this.subject = subject;
        this.full_text = full_text;
        this.imageUrls = imageUrls;
        this.authorName = authorName;
        this.authorImgUrl = authorImgUrl;
    }
}
