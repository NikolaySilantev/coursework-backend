package com.example.coursework.mappers;

import com.example.coursework.dto.*;
import com.example.coursework.models.Image;
import com.example.coursework.models.Review;
import com.example.coursework.models.Tag;
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
    @Mapping(target="authorName", source="review.user.username")
    @Mapping(target="authorImgUrl", source="review.user.imageUrl")
    HomeReviewDto reviewToHomeReviewDto(Review review);
    default String imageToImageUrl(Image image) {return image.getUrl();}
    Set<String> imagesToImageUrls (Set<Image> images);
    @Mapping(target="authorName", source="review.user.username")
    @Mapping(target="authorImgUrl", source="review.user.imageUrl")
    @Mapping(target = "imageUrls", source = "images")
    ReviewDetailsDto reviewToReviewDetailsDto(Review review);
    @Mapping(target = "imageUrls", source = "images")
    UserReviewDto reviewToUserReviewDto (Review review);
    Set<Tag> tagNamesToTags (Set<String> tags);
    @Mapping(target = "name", source = "tag")
    Tag tagNameToTag (String tag);
    default String tagToTagName(Tag tag) {return tag.getName();}
    Set<String> tagsToTagNames(Set<Tag> tags);
}
