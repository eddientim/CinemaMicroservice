package com.demo.cinemamicroservice.cinemaservice.repositories;

import com.demo.cinemamicroservice.cinemaservice.repositories.models.CinemaShowing;

import java.util.Optional;

public class CinemaShowingImpl implements CinemaShowingRepository {

    @Override
    public Optional<CinemaShowing> findByCinemaShowing(Long movieId) {
        return Optional.empty();
    }

    @Override
    public Optional<CinemaShowing> findByCinemaShowing(Long movieId, String movieTitle) {
        return Optional.empty();
    }

}
