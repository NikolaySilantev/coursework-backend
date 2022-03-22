package com.example.coursework.controllers;

import com.example.coursework.dto.UserControlDto;
import com.example.coursework.dto.UserProfileDto;
import com.example.coursework.mappers.UserMapper;
import com.example.coursework.payload.response.MessageResponse;
import com.example.coursework.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all")
    public List<UserControlDto> getAllUsers() {
        return userService.findAll().stream()
                .map(user -> (userMapper.UserToUserControlDto(user))).collect(Collectors.toList());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/block")
    public ResponseEntity<?> blockUsers(@RequestBody List<Long> ids) {
        return ResponseEntity.ok(new MessageResponse(
                userService.blockUsers(ids)
        ));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/unblock")
    public ResponseEntity<?> unblockUsers(@RequestBody List<Long> ids) {
        return ResponseEntity.ok(new MessageResponse(
                userService.unblockUsers(ids)
        ));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/delete")
    public ResponseEntity<?> deleteUsers(@RequestBody List<Long> ids) {
        return ResponseEntity.ok(new MessageResponse(
                userService.deleteUsers(ids)
        ));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/admin")
    public ResponseEntity<?> makeAdminUsers(@RequestBody List<Long> ids) {
        return ResponseEntity.ok(new MessageResponse(
                userService.makeAdminUsers(ids)
        ));
    }
}
