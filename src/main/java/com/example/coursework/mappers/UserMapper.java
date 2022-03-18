package com.example.coursework.mappers;

import com.example.coursework.dto.UserControlDto;
import com.example.coursework.dto.UserProfileDto;
import com.example.coursework.models.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserProfileDto UserToUserProfileDto(User user);

    UserControlDto UserToUserControlDto(User user);
}
