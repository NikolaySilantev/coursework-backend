package com.example.coursework.mappers;

import com.example.coursework.dto.HomeReviewDto;
import com.example.coursework.dto.ReviewDto;
import com.example.coursework.models.Review;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface ReviewMapper {
    Review reviewDtoToReview (ReviewDto reviewDto);
    @Mapping(target="authorId", source="review.user.id")
    @Mapping(target="authorName", source="review.user.username")
    @Mapping(target="authorImgUrl", source="review.user.imageUrl")
    HomeReviewDto reviewToHomeReviewDto(Review review);
}
