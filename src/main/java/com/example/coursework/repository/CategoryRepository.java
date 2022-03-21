package com.example.coursework.repository;

import com.example.coursework.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Category, Long> {
}
