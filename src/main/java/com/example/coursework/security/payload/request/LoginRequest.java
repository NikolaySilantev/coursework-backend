package com.example.coursework.security.payload.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginRequest {
    @NotBlank(message = "{field.required}")
    private String username;

    @NotBlank(message = "{field.required}")
    private String password;
}
