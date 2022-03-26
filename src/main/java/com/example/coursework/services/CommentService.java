package com.example.coursework.services;

import com.example.coursework.models.Comment;
import com.example.coursework.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserService userService;

    public void saveComment (Comment comment) {
        comment.setReleaseDate(new Timestamp(System.currentTimeMillis()));
        comment.setUser(userService.loadUserByUsername(comment.getUser().getUsername()));
        commentRepository.save(comment);
    }

    public List<Comment> findCommentsByReviewId (Long reviewId) {
        return commentRepository.findAllByReviewId(reviewId);
    }
}
