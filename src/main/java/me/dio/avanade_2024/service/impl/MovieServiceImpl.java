package me.dio.avanade_2024.service.impl;

import me.dio.avanade_2024.domain.model.Movie;
import me.dio.avanade_2024.domain.repository.MovieRepository;
import me.dio.avanade_2024.domain.repository.UserRepository;
import me.dio.avanade_2024.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    @Override
    public Movie findById(Long id) {
        return null;
    }

    @Override
    public Movie findByTitle(String title) {
        return null;
    }

    @Override
    public List<Movie> findAll() {
        return List.of();
    }

    @Override
    public Movie create(Movie movieToCreate) {
        return movieRepository.save(movieToCreate);
    }
}
