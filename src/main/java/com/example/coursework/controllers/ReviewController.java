package com.example.coursework.controllers;

import com.example.coursework.dto.HomeReviewDto;
import com.example.coursework.dto.ReviewDetailsDto;
import com.example.coursework.dto.ReviewDto;
import com.example.coursework.mappers.ReviewMapper;
import com.example.coursework.models.Review;
import com.example.coursework.payload.response.MessageResponse;
import com.example.coursework.repository.UserRepository;
import com.example.coursework.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
        Review sss = reviewMapper.reviewDtoToReview(reviewDto);
        return ResponseEntity.ok(new MessageResponse(
                reviewService.saveReview(sss, principal.getName())));
    }

    @GetMapping("/{id}")
    public ReviewDetailsDto getReview(@PathVariable(value = "id") long id) {
        //Review review = reviewService.findById(id);
        //ReviewDetailsDto reviewDetailsDto = reviewMapper.reviewToReviewDetailsDto(review);
        return reviewMapper.reviewToReviewDetailsDto(reviewService.findById(id));
    }
}
