package me.dio.avanade_2024.domain.repository;

import me.dio.avanade_2024.domain.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
