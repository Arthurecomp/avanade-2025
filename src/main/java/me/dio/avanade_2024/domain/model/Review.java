package me.dio.avanade_2024.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "tb_review")
@Getter
@Setter
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comment;
    private int rating;
    @ManyToOne
    private Movie movie;

    public Review(String comment, int rating, Movie movie) {
        this.comment = comment;
        this.rating = rating;
        this.movie = movie;
    }
    public Review() {

    }


}
