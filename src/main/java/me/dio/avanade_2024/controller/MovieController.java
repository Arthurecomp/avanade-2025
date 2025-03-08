package me.dio.avanade_2024.controller;

import me.dio.avanade_2024.domain.model.Movie;
import me.dio.avanade_2024.domain.model.User;
import me.dio.avanade_2024.service.MovieService;
import me.dio.avanade_2024.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movie")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }


    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.findAll();
    }



    @PostMapping
    public ResponseEntity<Movie> save(@RequestBody Movie movieToCreate) {
        var movieCreated = movieService.create(movieToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(movieCreated
                        .getId()).toUri();
        return ResponseEntity.created(location).body(movieCreated);
    }
}
