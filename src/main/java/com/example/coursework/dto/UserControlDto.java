package com.example.coursework.dto;

import lombok.Data;

@Data
public class UserControlDto {
    private Long id;
    private String username;
    private String email;
    private Boolean unblocked;
    private Boolean isAdmin;

    public UserControlDto(Long id, String username, String email, Boolean unblocked) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.unblocked = unblocked;
    }
}
