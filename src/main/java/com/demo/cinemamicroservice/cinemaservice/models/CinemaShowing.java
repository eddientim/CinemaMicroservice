package com.demo.cinemamicroservice.cinemaservice.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.ec2.model.Reservation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Collection;

@ToString
@Builder
@AllArgsConstructor
@EqualsAndHashCode
@DynamoDBTable(tableName = "cinema_showing")
public class CinemaShowing extends BaseModel {
    private Long movieId;
    private String movieTitle;
    private String posterPath;
    private Timetable timetable;
    private ShowingType showingType;
    private Room room;
    private BigDecimal ticketPrice;
    private Collection<Reservation> reservations;

    private String formattedShowings; //stored entity

    protected CinemaShowing() {
    }

    public CinemaShowing(Long movieId, String movieTitle, String posterPath, Timetable timetable, ShowingType showingType, Room room, BigDecimal ticketPrice) {
        this.movieId = movieId;
        this.movieTitle = movieTitle;
        this.posterPath = posterPath;
        this.timetable = timetable;
        this.showingType = showingType;
        this.room = room;
        this.ticketPrice = ticketPrice;
    }

    public CinemaShowing(Long movieId, Timetable timetable, ShowingType showingType, Room room) {
        this.movieId = movieId;
        this.timetable = timetable;
        this.showingType = showingType;
        this.room = room;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    @DynamoDBAttribute
    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    @DynamoDBAttribute
    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    @DynamoDBAttribute
    public Timetable getTimetable() {
        return timetable;
    }

    public void setTimetable(Timetable timetable) {
        this.timetable = timetable;
    }

    @DynamoDBAttribute
    public ShowingType getShowingType() {
        return showingType;
    }

    public void setShowingType(ShowingType showingType) {
        this.showingType = showingType;
    }

    @DynamoDBAttribute
    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @DynamoDBAttribute
    public BigDecimal getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(BigDecimal ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    @DynamoDBAttribute
    public Collection<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Collection<Reservation> reservations) {
        this.reservations = reservations;
    }
}
