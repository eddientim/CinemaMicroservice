package com.demo.cinemamicroservice.cinemaservice.repositories.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

import java.time.Instant;

@DynamoDBDocument
public class Timetable {

    private Instant startTime;
    private Instant endTime;
    private Instant date;

    public Timetable(Instant startTime, Instant endTime, Instant date) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.date = date;
    }

    @DynamoDBAttribute
    public Instant getStartTime() {
        return startTime;
    }

    public void setStartTime(Instant startTime) {
        this.startTime = startTime;
    }

    @DynamoDBAttribute
    public Instant getEndTime() {
        return endTime;
    }

    public void setEndTime(Instant endTime) {
        this.endTime = endTime;
    }

    @DynamoDBAttribute
    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

}
