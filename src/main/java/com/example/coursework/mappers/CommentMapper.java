package com.example.coursework.mappers;

import com.example.coursework.dto.CommentDto;
import com.example.coursework.models.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    @Mapping(target = "authorName", source = "comment.user.username")
    @Mapping(target = "authorImgUrl", source = "comment.user.imageUrl")
    CommentDto commentToCommentDto (Comment comment);

    List<CommentDto> commentsToCommentDtos(List<Comment> comments);

    @Mapping(target = "user.username", source = "authorName")
    @Mapping(target = "review.id", source = "reviewId")
    Comment commentDtoToComment (CommentDto commentDto);
}
