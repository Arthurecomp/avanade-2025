package me.dio.avanade_2024.controller;

import me.dio.avanade_2024.domain.model.Movie;
import me.dio.avanade_2024.service.MovieService;
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

    @GetMapping("{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable Long id) {
        Movie movie = movieService.findById(id);
        return (movie!=null) ? ResponseEntity.ok(movie) : ResponseEntity.notFound().build();
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<Movie> getMovieByTitle(@PathVariable String title) {
        Optional<Movie> movie = movieService.findByTitle(title);
        return movie.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        List<Movie> movies = movieService.findAll();
        return ResponseEntity.ok(movies);
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
