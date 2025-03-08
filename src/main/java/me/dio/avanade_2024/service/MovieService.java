package me.dio.avanade_2024.service;

import me.dio.avanade_2024.domain.model.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    Movie findById(Long id);
    Optional<Movie> findByTitle(String title);
    List<Movie> findAll();
    Movie create(Movie movie);
}
