package com.demo.cinemamicroservice.cinemaservice.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.Collection;
import java.util.List;

@DynamoDBTable(tableName = "reservations")
public class Reservations {

    private List<CinemaShowing> cinemaShowing;
    private Long userId;
    private String username;
    private Collection<CinemaSeat> seats;
    private ReservationStatus status;


    protected Reservations() {
    }

    public Reservations(List<CinemaShowing> cinemaShowing, Long userId, ReservationStatus reservationStatus, Collection<CinemaSeat> seats) {
        this.cinemaShowing = cinemaShowing;
        this.userId = userId;
        this.status = reservationStatus;
        this.seats = seats;
    }

    public List<CinemaShowing> getCinemaShowing() {
        return cinemaShowing;
    }

    public void setCinemaShowing(List<CinemaShowing> cinemaShowing) {
        this.cinemaShowing = cinemaShowing;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Collection<CinemaSeat> getSeats() {
        return seats;
    }

    public void setSeats(Collection<CinemaSeat> seats) {
        this.seats = seats;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }
}
