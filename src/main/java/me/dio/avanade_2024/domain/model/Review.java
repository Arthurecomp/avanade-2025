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
    @JoinColumn(name = "movie_id")  // Define explicitamente o nome da coluna de chave estrangeira
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "user_id")  // Define explicitamente o nome da coluna de chave estrangeira
    private User user;


    public Review() {}


    public Review(String comment, int rating, Movie movie, User user) {
        this.comment = comment;
        this.rating = rating;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
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
