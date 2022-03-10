package com.example.coursework.services;

import com.example.coursework.models.Tag;
import com.example.coursework.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class TagService {
    @Autowired
    TagRepository tagRepository;

    public Tag findTag (String tagName) {
        return tagRepository.findByName(tagName).get();
    }

    public Set<Tag> saveTags (Set<Tag> tags) {
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
