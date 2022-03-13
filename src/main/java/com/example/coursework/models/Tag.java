package com.example.coursework.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLInsert;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tags",
        uniqueConstraints = {
        @UniqueConstraint(columnNames = "name")
        })
//@SQLInsert(sql = "INSERT IGNORE INTO tags(name) " +
//        "VALUES (?)")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    //private Long count;

    public Tag() {
    }

    public Tag(String name) {
        this.name = name;
    }
}
