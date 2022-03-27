package com.example.coursework.dto;

import com.example.coursework.constants.Constants;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
public class ReviewEditDto {
    private Long id;
    @NotBlank(message = "{field.required}")
    @Size(min = Constants.MIN_REVIEW_TITLE_SIZE, max = Constants.MAX_REVIEW_TITLE_SIZE, message = "{review.title.size}")
    private String title;
    @NotBlank(message = "{field.required}")
    private String category;
    @NotBlank(message = "{field.required}")
    @Size(min = Constants.MIN_REVIEW_TEXT_SIZE, max = Constants.MAX_REVIEW_TEXT_SIZE, message = "{review.full_text.size}")
    private String full_text;
    private Double authorScore;
    private Set<String> imageUrls;
    private Set<String> tags;

    public ReviewEditDto(Long id, String title, String category, String full_text, Double authorScore, Set<String> imageUrls, Set<String> tags) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.full_text = full_text;
        this.authorScore = authorScore;
        this.imageUrls = imageUrls;
        this.tags = tags;
    }
}
