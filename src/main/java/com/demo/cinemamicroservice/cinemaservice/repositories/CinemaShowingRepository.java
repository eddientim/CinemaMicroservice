package com.demo.cinemamicroservice.cinemaservice.repositories;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CinemaShowingRepository extends CrudRepository<CinemaShowingRepository, Long> {

    /**
     * This finds the cinema showings and returns a list
     * @param Id
     * @return a movie ID
     */
    Optional<CinemaShowingRepository> findByCinemaShowingRepository(Long Id);
}
