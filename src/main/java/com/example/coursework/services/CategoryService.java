package com.example.coursework.services;

import com.example.coursework.models.Category;
import com.example.coursework.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findCategory(String categoryName) {
        return categoryRepository.findByName(categoryName).get();
    }
}
