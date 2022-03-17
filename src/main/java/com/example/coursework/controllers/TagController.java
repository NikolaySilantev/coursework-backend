package com.example.coursework.controllers;

import com.example.coursework.models.Tag;
import com.example.coursework.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/tag")
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping("/all")
    public List<Tag> getAllTags() {
        return tagService.findAll();
    }

    @GetMapping("/top")
    public Map<String, Long> getTopTags() {
        return tagService.findTopTags();
    }
}
