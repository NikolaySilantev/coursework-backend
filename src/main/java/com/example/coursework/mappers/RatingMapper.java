package com.example.coursework.mappers;

import com.example.coursework.dto.LikeDto;
import com.example.coursework.models.Like;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RatingMapper {
    @Mapping(target="user.id", source="userId")
    @Mapping(target="review.id", source="reviewId")
    Like likeDtoToLike(LikeDto likeDto);
}
