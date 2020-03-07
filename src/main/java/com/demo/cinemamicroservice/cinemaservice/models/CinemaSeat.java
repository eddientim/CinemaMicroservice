package com.demo.cinemamicroservice.cinemaservice.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@ToString
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@DynamoDBTable(tableName = "cinema_seat")
public class CinemaSeat {

    private Integer rowNum;
    private Integer colNum;
    private String mark;
    private List<Reservations> reservations;

    protected CinemaSeat() {
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
    public List<Reservations> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservations> reservations) {
        this.reservations = reservations;
    }
}
