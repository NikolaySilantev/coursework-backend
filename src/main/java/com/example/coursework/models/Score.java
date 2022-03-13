package com.example.coursework.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "scores")
public class Score {
    @Id
    private Long id;
    private Long userId;
    private Long reviewId;
    private byte score;
}
