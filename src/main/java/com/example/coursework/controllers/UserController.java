package com.example.coursework.controllers;

import com.example.coursework.dto.ReviewDetailsDto;
import com.example.coursework.dto.UserProfileDto;
import com.example.coursework.dto.UserReviewDto;
import com.example.coursework.mappers.ReviewMapper;
import com.example.coursework.mappers.UserMapper;
import com.example.coursework.models.User;
import com.example.coursework.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/{username}")
    public UserProfileDto getReview(@PathVariable(value = "username") String username) {
        return userMapper.UserToUserProfileDto(userService.loadUserByUsername(username));
    }
}
