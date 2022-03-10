package com.example.coursework.repository;

import com.example.coursework.models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
//    @Modifying
//    @Query(value = "insert into tags (name) values (:name, :age, :email, :status)",
//            nativeQuery = true)
//    void saveIgnore (Tag tag);
    Optional<Tag> findByName (String name);

    Set<Tag> findAllByNameIn(Set<String> names);
}
