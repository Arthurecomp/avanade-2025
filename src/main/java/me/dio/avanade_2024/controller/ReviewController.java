package me.dio.avanade_2024.controller;

import me.dio.avanade_2024.domain.model.Review;
import me.dio.avanade_2024.domain.model.ReviewDTO;
import me.dio.avanade_2024.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reviews")
public class ReviewController {


    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/add")
    public ResponseEntity<Review> addReview(@RequestBody ReviewDTO reviewDTO) {
        Review review = reviewService.addReview(
                reviewDTO.userId(), reviewDTO.movieId(), reviewDTO.content(), reviewDTO.rating()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(review);
    }

}
