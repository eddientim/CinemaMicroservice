package com.demo.cinemamicroservice.cinemaservice.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Collection;

@DynamoDBTable(tableName = "timetable")
public class Timetable extends BaseModel implements Comparable<Timetable> {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private Date startDateTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private Date endDateTime;
    private Collection<CinemaShowing> cinemaShowings;

    public Timetable(Date startDateTime, Date endDateTime) {
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }

    @DynamoDBAttribute
    public Date getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(Date startDateTime) {
        this.startDateTime = startDateTime;
    }
    @DynamoDBAttribute
    public Date getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(Date endDateTime) {
        this.endDateTime = endDateTime;
    }

    @DynamoDBAttribute
    public Collection<CinemaShowing> getCinemaShowings() {
        return cinemaShowings;
    }

    public void setCinemaShowings(Collection<CinemaShowing> cinemaShowings) {
        this.cinemaShowings = cinemaShowings;
    }

    @Override
    public int compareTo(Timetable t) {
        if (startDateTime.equals(t.startDateTime)) return 0;
        else if (startDateTime.before(t.startDateTime)) return 1;
        else return -1;
    }
}
