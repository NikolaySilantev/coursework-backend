package com.example.coursework.services;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.coursework.models.Image;
import com.example.coursework.models.Review;
import com.example.coursework.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private Cloudinary cloudinary;

    public String convertUrlToPublicId (String url) {
        String[] splitUrl = url.split("/");
        String publicId = splitUrl[splitUrl.length - 1].split("\\.")[0];
        return publicId;
    }

    public List<String> getPublicIds(Set<Image> images) {
        List<String> result;
        result=images.stream().map(image -> convertUrlToPublicId(image.getUrl())).collect(Collectors.toList());
        return result;
    }

    public void editImages(Review review, Review reviewFromDb) throws Exception {
        deleteImagesFromCloudinary(reviewFromDb.getImages());
        imageRepository.deleteAllByReviewId(review.getId());
        saveImages(review);
    }

    public void saveImages(Review review) {
        for (Image img : review.getImages()
        ) {
            img.setReview(review);
        }
        imageRepository.saveAll(review.getImages());
    }

    public void deleteImagesFromCloudinary(Set<Image> images) throws Exception {
        if (images.size() != 0) {
            Map deleteParams = ObjectUtils.asMap("invalidate", true);
            cloudinary.api().deleteResources(getPublicIds(images), deleteParams);
        }
    }
}
