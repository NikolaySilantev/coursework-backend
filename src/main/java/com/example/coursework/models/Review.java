package com.example.coursework.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Indexed
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Field
    private String title;
    @Field
    private String subject;
    @Type(type = "text")
    @Field
    private String full_text;

    private float authorScore;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy="review", cascade = { CascadeType.REMOVE })
    private Set<Image> images;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "review_tags",
            joinColumns = @JoinColumn(name = "review_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    @IndexedEmbedded
    private Set<Tag> tags;

    @OneToMany(mappedBy="review", cascade = { CascadeType.REMOVE })
    private Set<Like> likes;

    public Review() {
    }

    public Review(String title, String subject, String full_text) {
        this.title = title;
        this.subject = subject;
        this.full_text = full_text;
    }
}
