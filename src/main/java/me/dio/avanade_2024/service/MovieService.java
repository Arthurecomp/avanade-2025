package me.dio.avanade_2024.service;

import me.dio.avanade_2024.domain.model.Movie;

import java.util.List;

public interface MovieService {
    Movie findById(Long id);
    Movie findByTitle(String title);
    List<Movie> findAll();
    Movie create(Movie movie);
}
