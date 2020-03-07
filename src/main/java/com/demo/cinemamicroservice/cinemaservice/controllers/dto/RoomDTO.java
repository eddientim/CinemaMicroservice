package com.demo.cinemamicroservice.cinemaservice.controllers.dto;

public class RoomDTO {

    public String title;

    public Integer numSeats;

    public Integer numRows;

    public Integer numCols;

    public String description;

    protected RoomDTO() {
    }

    public RoomDTO(String title, Integer numSeats, Integer numRows, Integer numCols, String description) {
        this.title = title;
        this.numSeats = numSeats;
        this.numRows = numRows;
        this.numCols = numCols;
        this.description = description;
    }
}
