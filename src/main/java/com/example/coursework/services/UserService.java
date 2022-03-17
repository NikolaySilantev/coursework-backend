package com.example.coursework.services;

import com.example.coursework.models.ERole;
import com.example.coursework.models.Role;
import com.example.coursework.models.User;
import com.example.coursework.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
        return user;
    }

    public boolean isAdmin(String username) {
        return loadUserByUsername(username).getRoles().stream()
                .map(Role::getName).collect(Collectors.toSet()).contains(ERole.ROLE_ADMIN);
    }
}
