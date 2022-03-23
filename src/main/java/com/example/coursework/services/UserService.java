package com.example.coursework.services;

import com.example.coursework.models.ERole;
import com.example.coursework.models.Review;
import com.example.coursework.models.Role;
import com.example.coursework.models.User;
import com.example.coursework.repository.RoleRepository;
import com.example.coursework.repository.UserRepository;
import com.sun.net.httpserver.Authenticator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
        return user;
    }

    public void updateUserRating(User user, Integer difference) {
        user.setRating(user.getRating() + difference);
        userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public boolean isAdmin(String username) {
        return loadUserByUsername(username).getRoles().stream()
                .map(Role::getName).collect(Collectors.toSet()).contains(ERole.ROLE_ADMIN);
    }

    public boolean isAdmin(User user) {
        return user.getRoles().stream()
                .map(Role::getName).collect(Collectors.toSet()).contains(ERole.ROLE_ADMIN);
    }

    public String blockUsers (List <Long> ids) {
        List<User> blockedUsers = new ArrayList<>();
        for (Long id : ids) {
            User user = findUserById(id);
            user.setUnblocked(false);
            blockedUsers.add(user);
        }
        userRepository.saveAll(blockedUsers);
        return "Successfully!";
    }

    public String unblockUsers (List <Long> ids) {
        List<User> unblockedUsers = new ArrayList<>();
        for (Long id : ids) {
            User user = findUserById(id);
            user.setUnblocked(true);
            unblockedUsers.add(user);
        }
        userRepository.saveAll(unblockedUsers);
        return "Successfully!";
    }

    public String deleteUsers (List <Long> ids) {
        List<User> deletedUsers = new ArrayList<>();
        for (Long id : ids) {
            User user = findUserById(id);
            deletedUsers.add(user);
        }
        userRepository.deleteAll(deletedUsers);
        return "Successfully!";
    }

    public String makeAdminUsers (List <Long> ids) {
        List<User> madeAdminUsers = new ArrayList<>();
        for (Long id : ids) {
            User user = findUserById(id);
            if (!isAdmin(user)) {
                user.getRoles().add(roleRepository.findByName(ERole.ROLE_ADMIN)
                        .orElseThrow(() -> new RuntimeException("Error: Role is not found.")));
                madeAdminUsers.add(user);
            }
        }
        userRepository.saveAll(madeAdminUsers);
        return "Successfully!";
    }

    public User findUserById(Long id) {
        return userRepository.getById(id);
    }
}
