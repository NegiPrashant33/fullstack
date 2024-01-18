package com.prashant.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "recipes")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne
    private User user;

    private String image;

    private String description;

    @Column(name = "vegetarian")
    private boolean vegetarian;

    private LocalDateTime createdAt;

    private List<Long> likes = new ArrayList<>();
}
