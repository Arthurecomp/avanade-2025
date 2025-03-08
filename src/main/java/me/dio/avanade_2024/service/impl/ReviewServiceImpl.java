package me.dio.avanade_2024.service.impl;

import me.dio.avanade_2024.domain.model.Movie;
import me.dio.avanade_2024.domain.model.Review;
import me.dio.avanade_2024.domain.model.User;
import me.dio.avanade_2024.domain.repository.MovieRepository;
import me.dio.avanade_2024.domain.repository.ReviewRepository;
import me.dio.avanade_2024.domain.repository.UserRepository;
import me.dio.avanade_2024.service.ReviewService;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {


    private UserRepository userRepository;
    private ReviewRepository reviewRepository;
    private MovieRepository movieRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository, MovieRepository movieRepository, UserRepository userRepository) {
        this.reviewRepository = reviewRepository;
        this.movieRepository = movieRepository;
        this.userRepository = userRepository;
    }
    @Override
    public Review addReview(Long userId, Long movieId, String content, int rating) {
        User user = userRepository.findById(userId).orElse(null);
        Movie movie = movieRepository.findById(movieId).orElse(null);

        if (user == null || movie == null) {

            return null;
        }
        Review review = new Review();
        review.setComment(content);
        review.setRating(rating);
        review.setMovie(movie);
        review.setUser(user);
        user.getReviews().add(review);
        userRepository.save(user);
        return reviewRepository.save(review);
    }
}
