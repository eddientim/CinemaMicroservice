package com.demo.cinemamicroservice.cinemaservice.repositories.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * This class checks if there is a duplicate Id found
 */
@Getter
@NoArgsConstructor
public class DuplicateIMovieIdException extends Exception {

    private long duplicateCount;

    public DuplicateIMovieIdException(long duplicateCount) {
        super();
        this.duplicateCount = duplicateCount;
    }
}
