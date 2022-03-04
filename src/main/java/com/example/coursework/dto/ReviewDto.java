package com.example.coursework.dto;

import lombok.Data;

@Data
public class ReviewDto {
    private String title;
    private String subject;
    private String full_text;

    public ReviewDto(String title, String subject, String full_text) {
        this.title = title;
        this.subject = subject;
        this.full_text = full_text;
    }
}
