package com.example.coursework.dto;

import lombok.Data;

@Data
public class ImageDto {
    String url;

    public ImageDto(String url) {
        this.url = url;
    }
}
