package com.demo.cinemamicroservice.cinemaservice.repositories;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CinemaSeatRepository extends CrudRepository<CinemaSeatRepository, String> {

    List<CinemaSeatRepository> findByMyId(String id);
}
