package me.dio.avanade_2024.service;

import me.dio.avanade_2024.domain.model.Movie;
import me.dio.avanade_2024.domain.model.User;
import me.dio.avanade_2024.domain.model.credential.RegisterDTO;

import java.util.List;

public interface UserService {

    User findById(Long id);
    List<User> findAll();
    User addWatchedMovie(Long userId, Long movieId);
    List<Movie> getWatchedMovie(Long userId);
}
