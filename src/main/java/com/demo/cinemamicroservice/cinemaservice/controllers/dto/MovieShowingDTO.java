package com.demo.cinemamicroservice.cinemaservice.controllers.dto;

import com.demo.cinemamicroservice.cinemaservice.models.CinemaShowing;
import com.demo.cinemamicroservice.cinemaservice.models.ShowingType;

import java.math.BigDecimal;

public class MovieShowingDTO {
    public Long movieId;
    public String movieTitle;
    public String posterPath;
    public ShowingType showingType;
    public Long roomId;
    public BigDecimal ticketPrice;
    public String showingTimes;

    public MovieShowingDTO() {
    }

    public MovieShowingDTO(CinemaShowing cinemaShowing) {
        this.movieId = cinemaShowing.getMovieId();
        this.movieTitle = cinemaShowing.getMovieTitle();
        this.posterPath = cinemaShowing.getPosterPath();
        this.showingType = cinemaShowing.getShowingType();
        this.roomId = cinemaShowing.getRoom().getId();
        this.ticketPrice = cinemaShowing.getTicketPrice();
    }
}
