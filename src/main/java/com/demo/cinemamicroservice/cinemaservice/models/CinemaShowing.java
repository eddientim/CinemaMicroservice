package com.demo.cinemamicroservice.cinemaservice.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Collection;
import java.util.List;

@ToString
@Builder
@AllArgsConstructor
@DynamoDBTable(tableName = "cinema_showing")
public class CinemaShowing {

    @Id
    private Long movieId;
    private String movieTitle;
    private String posterPath;
    private Integer room;
    private BigDecimal ticketPrice;
    private Collection<Reservations> reservations;
    private List<Timetable> timetable;

    protected CinemaShowing() {
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
    public Integer getRoom() {
        return room;
    }

    public void setRoom(Integer room) {
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
    public Collection<Reservations> getReservations() {
        return reservations;
    }

    public void setReservations(Collection<Reservations> reservations) {
        this.reservations = reservations;
    }

    @DynamoDBAttribute
    public List<Timetable> timetable() {
        return timetable;
    }

    public void setTimetable(List<Timetable> timetable) {
        this.timetable = timetable;
    }


}
