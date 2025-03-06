package me.dio.avanade_2024.domain.model;

import jakarta.persistence.*;

@Entity(name = "tb_favorite")
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Movie movie;
    @ManyToOne
    private User user;
}
