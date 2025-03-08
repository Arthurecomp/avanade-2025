package me.dio.avanade_2024.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import me.dio.avanade_2024.domain.model.Movie;
import me.dio.avanade_2024.domain.model.User;
import me.dio.avanade_2024.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")

public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        var user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> users = userService.findAll();
        return ResponseEntity.ok(users);
    }

    @PostMapping("/{userId}/watched/{movieId}")
    public ResponseEntity<User> watch(@PathVariable Long userId, @PathVariable Long movieId) {
        User userUpdateMovie = userService.addWatchedMovie(userId, movieId);
        return ResponseEntity.ok(userUpdateMovie);
    }

    @GetMapping("/{userId}/watched")
    public ResponseEntity<List<Movie>> watched(@PathVariable Long userId) {
        List<Movie> watchedMovies = userService.getWatchedMovie(userId);
        return ResponseEntity.ok(watchedMovies);
    }
}
