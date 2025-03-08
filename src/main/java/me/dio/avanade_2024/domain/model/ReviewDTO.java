package me.dio.avanade_2024.domain.model;

public record ReviewDTO(Long userId, Long movieId, String content, int rating) {
}
