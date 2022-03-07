package com.example.coursework.services;

import com.example.coursework.models.Image;
import com.example.coursework.models.Review;
import com.example.coursework.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;

    public void saveImages (Review review) {
        for (Image img : review.getImages()
             ) {
            img.setReview(review);
        }
        imageRepository.saveAll(review.getImages());
    }
}
