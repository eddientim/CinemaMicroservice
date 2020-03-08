package com.demo.cinemamicroservice.cinemaservice.controllers.dto;

import java.math.BigDecimal;

public class CinemaShowingDTO {

    private BigDecimal ticketPrice;
    private String showingTimes;
    private Integer duration;
    private Long roomId;
    private String startTime;
    private String startDate;
    private String posterPath;
    private String movieTitle;
    private Long movieId;


    protected CinemaShowingDTO() {
    }

    public CinemaShowingDTO(Long movieId, String movieTitle, String posterPath, String startDate, String startTime,
                            Long roomId, Integer duration, String showingTimes, BigDecimal ticketPrice) {
        this.movieId = movieId;
        this.movieTitle = movieTitle;
        this.posterPath = posterPath;
        this.startDate = startDate;
        this.startTime = startTime;
        this.roomId = roomId;
        this.duration = duration;
        this.showingTimes = showingTimes;
        this.ticketPrice = ticketPrice;
    }
}
