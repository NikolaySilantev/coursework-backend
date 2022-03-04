package com.example.coursework.controllers;

import com.example.coursework.dto.HomeReviewDto;
import com.example.coursework.dto.ReviewDto;
import com.example.coursework.mappers.ReviewMapper;
import com.example.coursework.models.Review;
import com.example.coursework.payload.response.MessageResponse;
import com.example.coursework.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;
    @Autowired
    private ReviewMapper reviewMapper;

    @GetMapping("/all")
    public List<HomeReviewDto> getAllReviews() {
        return reviewService.findAll().stream()
                .map(review -> (reviewMapper.reviewToHomeReviewDto(review))).collect(Collectors.toList());
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> addReview(@RequestBody ReviewDto reviewDto, Principal principal) {
        return ResponseEntity.ok(new MessageResponse(reviewService.saveReview(reviewMapper.reviewDtoToReview(reviewDto), principal.getName())));
    }

    @GetMapping("/{id}")
    public HomeReviewDto getReview(@PathVariable(value = "id") long id) {
        return reviewMapper.reviewToHomeReviewDto(reviewService.findById(id));
    }
}
