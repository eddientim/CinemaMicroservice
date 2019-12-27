//package com.demo.cinemamicroservice.cinemaservice.models;
//
//import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
//
//import java.util.Collection;
//
//@DynamoDBTable(tableName = "reservations")
//public class Reservations extends BaseModel {
//
//    private CinemaShowing cinemaShowing;
//    private Long userId;
//    private String username;
//    private Collection<CinemaSeat> seats;
//    private ReservationStatus status;
//
//
//    protected Reservations() {
//    }
//
//    public Reservations(CinemaShowing cinemaShowing, Long userId, ReservationStatus reservationStatus, Collection<CinemaSeat> seats) {
//        this.cinemaShowing = cinemaShowing;
//        this.userId = userId;
//        this.status = reservationStatus;
//        this.seats = seats;
//    }
//
//    public CinemaShowing getCinemaShowing() {
//        return cinemaShowing;
//    }
//
//    public void setCinemaShowing(CinemaShowing cinemaShowing) {
//        this.cinemaShowing = cinemaShowing;
//    }
//
//    public Long getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Long userId) {
//        this.userId = userId;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public Collection<CinemaSeat> getSeats() {
//        return seats;
//    }
//
//    public void setSeats(Collection<CinemaSeat> seats) {
//        this.seats = seats;
//    }
//
//    public ReservationStatus getStatus() {
//        return status;
//    }
//
//    public void setStatus(ReservationStatus status) {
//        this.status = status;
//    }
//}
