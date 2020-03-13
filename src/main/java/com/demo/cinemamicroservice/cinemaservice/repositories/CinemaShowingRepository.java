package com.demo.cinemamicroservice.cinemaservice.repositories;

import com.demo.cinemamicroservice.cinemaservice.repositories.models.CinemaShowing;
import com.demo.cinemamicroservice.cinemaservice.repositories.models.Reservations;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface CinemaShowingRepository {

    /**
     * This finds the cinema showings and returns a movieId
     * @param movieId
     * @return a movie ID
     */
    Optional<CinemaShowing> findByCinemaShowing(Long movieId);

    /**
     * This finds the cinema showings by movieId and movieTitle
     * @param movieId
     * @param movieTitle
     * @return movie Id and movie title
     */
    Optional<CinemaShowing> findByCinemaShowing(Long movieId, String movieTitle);
}
