package com.example.coursework.repository;

import com.example.coursework.models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
    Optional<Tag> findByName(String name);

    Set<Tag> findAllByNameIn(Set<String> names);

    @Query(value = "select name, count(*) as count from tags join review_tags\n" +
            "    on tags.id = review_tags.tag_id\n" +
            "group by name\n" +
            "order by count desc limit 20",
            nativeQuery = true)
    List<Object[]> countAllByName();
}
