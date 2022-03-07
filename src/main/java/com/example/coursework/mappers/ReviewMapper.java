package com.example.coursework.mappers;

import com.example.coursework.dto.HomeReviewDto;
import com.example.coursework.dto.ImageDto;
import com.example.coursework.dto.ReviewDetailsDto;
import com.example.coursework.dto.ReviewDto;
import com.example.coursework.models.Image;
import com.example.coursework.models.Review;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface ReviewMapper {
    @Mapping(target = "images", source = "imageUrls")
    Review reviewDtoToReview (ReviewDto reviewDto);
    @Mapping(target = "url", source = "imageUrl")
    Image imageUrlToImage (String imageUrl);
    Set<Image> imageUrlsToImages (Set<String> imageUrls);
    @Mapping(target="authorId", source="review.user.id")
    @Mapping(target="authorName", source="review.user.username")
    @Mapping(target="authorImgUrl", source="review.user.imageUrl")
    HomeReviewDto reviewToHomeReviewDto(Review review);
    default String imageToImageUrl(Image image) {return image.getUrl();}
    Set<String> imagesToImageUrls (Set<Image> images);
    @Mapping(target="authorId", source="review.user.id")
    @Mapping(target="authorName", source="review.user.username")
    @Mapping(target="authorImgUrl", source="review.user.imageUrl")
    @Mapping(target = "imageUrls", source = "images")
    ReviewDetailsDto reviewToReviewDetailsDto(Review review);
}
