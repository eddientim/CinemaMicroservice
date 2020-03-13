package com.demo.cinemamicroservice.cinemaservice.repositories.exceptions;

import org.springframework.http.HttpStatus;

public class ServiceNotFoundException extends RuntimeException {

    private String title;
    private HttpStatus status;

    public ServiceNotFoundException(String message) {
        super(message);
    }

    public ServiceNotFoundException(HttpStatus httpStatus) {
        super();
        this.title = "Not found";
        this.status = httpStatus;
    }

    public ServiceNotFoundException(String title, String message) {
        super(message);
        this.title = title;
    }
}
