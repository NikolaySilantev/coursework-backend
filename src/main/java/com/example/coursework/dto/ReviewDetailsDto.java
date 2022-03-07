package com.example.coursework.dto;

import lombok.Data;

import java.util.Set;

@Data
public class ReviewDetailsDto {
    private Long id;
    private String title;
    private String subject;
    private String full_text;
    private Set<String> imageUrls;

    private Long authorId;
    private String authorName;
    private String authorImgUrl;

    public ReviewDetailsDto(Long id, String title, String subject, String full_text, Set<String> imageUrls, Long authorId, String authorName, String authorImgUrl) {
        this.id = id;
        this.title = title;
        this.subject = subject;
        this.full_text = full_text;
        this.imageUrls = imageUrls;
        this.authorId = authorId;
        this.authorName = authorName;
        this.authorImgUrl = authorImgUrl;
    }
}
