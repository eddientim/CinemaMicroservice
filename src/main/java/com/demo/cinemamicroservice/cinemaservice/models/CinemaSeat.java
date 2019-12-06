package com.demo.cinemamicroservice.cinemaservice.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedDefault;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Collection;

@ToString
@Builder
@EqualsAndHashCode
@DynamoDBTable(tableName = "cinema_seat")
public class CinemaSeat extends BaseModel {

    private Room room;
    private Integer rowNum;
    private Integer colNum;
    private String mark;
    private Collection<Reservations> reservations;

    public CinemaSeat(Room room, Integer rowNum, Integer colNum, String mark, Collection<Reservations> reservations) {
        this.room = room;
        this.rowNum = rowNum;
        this.colNum = colNum;
        this.mark = mark;
        this.reservations = reservations;
    }

    protected CinemaSeat() {}

    @DynamoDBAutoGeneratedDefault("Table cinema_seat: Column room_id cannot be null")
    @DynamoDBAttribute
    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @DynamoDBAttribute
    public Integer getRowNum() { //Row for seats
        return rowNum;
    }

    public void setRowNum(Integer rowNum) {
        this.rowNum = rowNum;
    }

    @DynamoDBAttribute
    public Integer getColNum() { //column for seats
        return colNum;
    }

    public void setColNum(Integer colNum) {
        this.colNum = colNum;
    }

    @DynamoDBAttribute
    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    @DynamoDBAttribute
    public Collection<Reservations> getReservations() {
        return reservations;
    }

    public void setReservations(Collection<Reservations> reservations) {
        this.reservations = reservations;
    }
}