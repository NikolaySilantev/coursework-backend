package com.example.coursework.controllers;

import com.example.coursework.dto.UserProfileDto;
import com.example.coursework.mappers.UserMapper;
import com.example.coursework.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/{username}")
    public UserProfileDto getProfile(@PathVariable(value = "username") String username) {
        return userMapper.UserToUserProfileDto(userService.loadUserByUsername(username));
    }

    @GetMapping("/all")
    public UserProfileDto getUsers(@PathVariable(value = "username") String username) {
        return userMapper.UserToUserProfileDto(userService.loadUserByUsername(username));
    }
}
