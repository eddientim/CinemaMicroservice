package com.demo.cinemamicroservice.cinemaservice.repositories;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CinemaSeatRepository extends CrudRepository<CinemaSeatRepository, String> {

    @Override
    Optional<CinemaSeatRepository> findById(String id);
}
