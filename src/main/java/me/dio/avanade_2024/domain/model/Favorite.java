package me.dio.avanade_2024.domain.model;

import jakarta.persistence.*;

@Entity(name = "tb_favorite")
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "movie_id")  // Define o nome da coluna no banco de dados
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "user_id")   // Define o nome da coluna no banco de dados
    private User user;

    // Construtor padrão (requerido pelo JPA)
    public Favorite() {}

    // Construtor com parâmetros (opcional, para facilitar a criação)
    public Favorite(Movie movie, User user) {
        this.movie = movie;
        this.user = user;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
