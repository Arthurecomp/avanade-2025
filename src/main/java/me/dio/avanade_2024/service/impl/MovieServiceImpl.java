package me.dio.avanade_2024.service.impl;

import me.dio.avanade_2024.domain.model.Movie;
import me.dio.avanade_2024.domain.repository.MovieRepository;
import me.dio.avanade_2024.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    @Override
    public Movie findById(Long id){
        return movieRepository.findById(id).orElse(null);
    }

    @Override
    public Optional<Movie> findByTitle(String title) {
        return movieRepository.findByTitle(title);
    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public Movie create(Movie movieToCreate) {
        return movieRepository.save(movieToCreate);
    }
}
