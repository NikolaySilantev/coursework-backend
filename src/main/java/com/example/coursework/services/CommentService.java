package com.example.coursework.services;

import com.example.coursework.models.Comment;
import com.example.coursework.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public void saveComment (Comment comment) {
        commentRepository.save(comment);
    }

    public List<Comment> findCommentsByReviewId (Long reviewId) {
        return commentRepository.findAllByReviewId(reviewId);
    }
}
