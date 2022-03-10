package com.example.coursework.dto;

import com.example.coursework.models.Image;
import lombok.Data;

import java.util.Set;

@Data
public class ReviewDto {
    private String title;
    private String subject;
    private String full_text;
    private Set<String> imageUrls;
    private Set<String> tags;

    public ReviewDto(String title, String subject, String full_text, Set<String> imageUrls, Set<String> tags) {
        this.title = title;
        this.subject = subject;
        this.full_text = full_text;
        this.imageUrls = imageUrls;
        this.tags = tags;
    }
}
