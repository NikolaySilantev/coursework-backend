package com.example.coursework.dto;

import lombok.Data;
import java.util.Set;

@Data
public class UserReviewDto {
    private Long id;
    private String title;
    private String subject;
    private String full_text;
    private Set<String> imageUrls;

    public UserReviewDto(Long id, String title, String subject, String full_text, Set<String> imageUrls) {
        this.id = id;
        this.title = title;
        this.subject = subject;
        this.full_text = full_text;
        this.imageUrls = imageUrls;
    }
}
