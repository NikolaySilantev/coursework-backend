package com.example.coursework.dto;

import lombok.Data;

import java.util.Set;

@Data
public class ReviewEditDto {
    private Long id;
    private String title;
    private String subject;
    private String full_text;
    private Set<String> imageUrls;
    private Set<String> tags;

    public ReviewEditDto(Long id, String title, String subject, String full_text, Set<String> imageUrls, Set<String> tags) {
        this.id = id;
        this.title = title;
        this.subject = subject;
        this.full_text = full_text;
        this.imageUrls = imageUrls;
        this.tags = tags;
    }
}
