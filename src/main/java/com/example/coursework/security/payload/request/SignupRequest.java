package com.example.coursework.security.payload.request;

import com.example.coursework.constants.Constants;
import lombok.Data;

import java.util.Set;
import javax.validation.constraints.*;

@Data
public class SignupRequest {
    @NotBlank(message = "{field.required}")
    @Size(min = Constants.MIN_USERNAME_SIZE, max = Constants.MAX_USERNAME_SIZE, message = "{username.size}")
    private String username;

    @NotBlank(message = "{field.required}")
    @Size(max = Constants.MAX_EMAIL_SIZE, message = "{email.size}")
    @Email
    private String email;

    private Set<String> role;

    @NotBlank(message = "{field.required}")
    @Size(min = Constants.MIN_PASSWORD_SIZE, max = Constants.MAX_PASSWORD_SIZE, message = "{password.size}")
    private String password;
}