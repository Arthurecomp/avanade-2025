package me.dio.avanade_2024.service.impl;

import me.dio.avanade_2024.domain.model.Credentials;
import me.dio.avanade_2024.domain.model.User;
import me.dio.avanade_2024.domain.model.Movie;

import me.dio.avanade_2024.domain.repository.CredentialsRepository;
import me.dio.avanade_2024.domain.repository.MovieRepository;
import me.dio.avanade_2024.domain.repository.UserRepository;
import me.dio.avanade_2024.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class  UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final MovieRepository movieRepository;


    public UserServiceImpl(UserRepository userRepository, MovieRepository movieRepository) {
        this.userRepository = userRepository;
        this.movieRepository = movieRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User addWatchedMovie(Long userId, Long movieId) {
        User user = userRepository.findById(userId).orElseThrow(() ->  new RuntimeException("User not found"));
        Movie movie = movieRepository.findById(movieId).orElseThrow(() ->  new RuntimeException("Movie not found"));

        if(!user.getWatchedMovies().contains(movie)) {
            user.getWatchedMovies().add(movie);
            userRepository.save(user);
        }
        return user;
    }

    @Override
    public List<Movie> getWatchedMovie(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() ->  new RuntimeException("User not found"));

        return user.getWatchedMovies();
    }


}
