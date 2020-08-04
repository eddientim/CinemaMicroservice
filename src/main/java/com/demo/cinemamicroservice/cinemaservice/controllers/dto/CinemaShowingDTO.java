package com.demo.cinemamicroservice.cinemaservice.controllers.dto;

import com.demo.cinemamicroservice.cinemaservice.repositories.models.Reservations;
import com.demo.cinemamicroservice.cinemaservice.repositories.models.Timetable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CinemaShowingDTO {

    private Long movieId;
    private String movieTitle;
    private String posterPath;
    private Integer room;
    private BigDecimal ticketPrice;
    private List<Reservations> reservations;
    private List<Timetable> timetable;
}
