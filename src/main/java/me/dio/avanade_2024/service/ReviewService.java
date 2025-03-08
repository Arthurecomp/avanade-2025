package me.dio.avanade_2024.service;

import me.dio.avanade_2024.domain.model.Review;

public interface ReviewService {
    Review addReview(Long userId, Long movieId, String content, int rating);
}
