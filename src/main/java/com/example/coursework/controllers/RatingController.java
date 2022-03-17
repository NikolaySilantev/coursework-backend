package com.example.coursework.controllers;

import com.example.coursework.dto.LikeDto;
import com.example.coursework.mappers.RatingMapper;
import com.example.coursework.payload.response.MessageResponse;
import com.example.coursework.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @Autowired
    private RatingMapper ratingMapper;

    @PostMapping("/like")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> likeReview(@RequestBody LikeDto likeDto) {
        return ResponseEntity.ok(new MessageResponse(
                ratingService.likeReview(ratingMapper.likeDtoToLike(likeDto))));
    }
}
