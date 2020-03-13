package com.demo.cinemamicroservice.cinemaservice.repositories.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ModelNotFoundException extends Exception {
    public ModelNotFoundException(Throwable throwable) {
        super(throwable);
    }

    public ModelNotFoundException() {

    }
}
