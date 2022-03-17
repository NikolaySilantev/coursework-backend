package com.example.coursework.services;

import com.example.coursework.models.Tag;
import com.example.coursework.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class TagService {
    @Autowired
    private TagRepository tagRepository;

    public List<Tag> findAll() {
        return tagRepository.findAll();
    }

    public Tag findTag(String tagName) {
        return tagRepository.findByName(tagName).get();
    }

    public Map<String, Long> findTopTags() {
        List<Object[]> top = tagRepository.countAllByName();
        Map<String, Long> results = new HashMap<>();
        for (Object[] borderTypes : top) {
            results.put((String) borderTypes[0], ((BigInteger) borderTypes[1]).longValue());
        }
        return results;
    }

    public Set<Tag> saveTags(Set<Tag> tags) {
        Set<String> tagNames = tags.stream().map(Tag::getName).collect(Collectors.toSet());
        Set<Tag> existingTags = tagRepository.findAllByNameIn(tagNames);
        Set<String> existingTagsNames = existingTags.stream().map(Tag::getName).collect(Collectors.toSet());
        Set<String> newTagsNames = tagNames.stream()
                .filter(val -> !existingTagsNames.contains(val))
                .collect(Collectors.toSet());
        Set<Tag> newTags = newTagsNames.stream().map(Tag::new).collect(Collectors.toSet());
        tagRepository.saveAll(newTags);
        return Stream.concat(existingTags.stream(), newTags.stream())
                .collect(Collectors.toSet());
    }
}
