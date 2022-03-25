package com.example.coursework.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class CommentDto {
    private Long id;
    private Long reviewId;
    private String commentText;
    private Timestamp releaseDate;
    private String authorName;
    private String authorImgUrl;

    public CommentDto(Long id, Long reviewId, String commentText, Timestamp releaseDate, String authorName, String authorImgUrl) {
        this.id = id;
        this.reviewId = reviewId;
        this.commentText = commentText;
        this.releaseDate = releaseDate;
        this.authorName = authorName;
        this.authorImgUrl = authorImgUrl;
    }
}