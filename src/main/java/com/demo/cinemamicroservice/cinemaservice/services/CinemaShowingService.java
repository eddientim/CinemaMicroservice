package com.demo.cinemamicroservice.cinemaservice.services;

import com.demo.cinemamicroservice.cinemaservice.controllers.dto.CinemaShowingDTO;
import com.demo.cinemamicroservice.cinemaservice.repositories.dynamo.CinemaRepository;
import com.demo.cinemamicroservice.cinemaservice.repositories.exceptions.DuplicateIMovieIdException;
import com.demo.cinemamicroservice.cinemaservice.repositories.exceptions.ModelNotFoundException;
import com.demo.cinemamicroservice.cinemaservice.repositories.models.CinemaShowing;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CinemaShowingService {

    private final CinemaRepository repository;

    public CinemaShowingService(CinemaRepository repository) {
        this.repository = repository;
    }

//    public List<CinemaShowingDTO> cinemaShowingList(Long movieId) throws ModelNotFoundException, DuplicateIMovieIdException {
//        List<CinemaShowing> cinemaShowingList = repository.findByCinemaShowing(movieId);
//
//        return cinemaShowingList.stream()
//            .map()
//            .distinct()
//            .collect(Collectors.toList());
//    }
}
