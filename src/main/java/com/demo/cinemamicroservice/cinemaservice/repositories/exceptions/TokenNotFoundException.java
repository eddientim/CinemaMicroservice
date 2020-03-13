package com.demo.cinemamicroservice.cinemaservice.repositories.exceptions;

public class TokenNotFoundException extends RuntimeException {

    public TokenNotFoundException(String message) {
        super(message);
    }
}
