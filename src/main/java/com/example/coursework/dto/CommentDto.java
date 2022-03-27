package com.example.coursework.dto;

import com.example.coursework.constants.Constants;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Data
public class CommentDto {
    private Long id;
    private Long reviewId;
    @NotBlank(message = "{field.required}")
    @Size(min = Constants.MIN_COMMENT_SIZE, max = Constants.MAX_COMMENT_SIZE, message = "{comment.text.size}")
    private String commentText;
    private Timestamp releaseDate;
    @NotBlank(message = "{field.required}")
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