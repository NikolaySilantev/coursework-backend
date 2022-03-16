package com.example.coursework.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Indexed
@Table(name = "tags",
        uniqueConstraints = {
        @UniqueConstraint(columnNames = "name")
        })
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Field
    private String name;

    public Tag() {
    }

    public Tag(String name) {
        this.name = name;
    }
}
