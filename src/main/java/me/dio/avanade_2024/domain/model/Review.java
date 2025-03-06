package me.dio.avanade_2024.domain.model;

import jakarta.persistence.*;

@Entity(name = "tb_review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comment;
    private int rating;
    @ManyToOne
    private Movie movie;
    @ManyToOne
    private User user;
}
