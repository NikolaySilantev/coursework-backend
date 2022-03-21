package com.example.coursework.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Indexed
@Table(name = "categories",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "name")
        })
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Field
    private String name;

    @OneToMany(mappedBy = "group", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private Set<Review> reviews;

    public Group() {
    }

    public Group(String name) {
        this.name = name;
    }
}
