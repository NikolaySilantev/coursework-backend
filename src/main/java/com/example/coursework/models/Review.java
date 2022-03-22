package com.example.coursework.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;
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

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Type(type = "text")
    @Field
    private String full_text;

    private Double authorScore;
    private Double userScore;

    private Timestamp releaseDate = null;

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

    @OneToMany(mappedBy="review", cascade = { CascadeType.REMOVE })
    private Set<Score> scores;

    public Review() {
    }

    public Review(String title, String full_text) {
        this.title = title;
        this.full_text = full_text;
    }
}
