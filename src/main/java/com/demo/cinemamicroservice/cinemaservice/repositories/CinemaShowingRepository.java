package com.demo.cinemamicroservice.cinemaservice.repositories;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CinemaShowingRepository extends CrudRepository<CinemaShowingRepository, Long> {

    @Override
    Optional<CinemaShowingRepository> findById(Long Id);
}
