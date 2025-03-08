package me.dio.avanade_2024.domain.repository;

import me.dio.avanade_2024.domain.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    Optional<Movie> findByTitle(String title);
}
