package com.demo.cinemamicroservice.cinemaservice.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.ec2.model.Reservation;

import java.util.Collection;

@DynamoDBTable(tableName = "reservation_status")
public class ReservationStatus extends BaseModel {


    private String statusTitle;
    private Collection<Reservation> reservations;

    protected ReservationStatus() {}

    public ReservationStatus(String statusTitle, Collection<Reservation> reservations) {
        this.statusTitle = statusTitle;
        this.reservations = reservations;
    }

    @DynamoDBAttribute
    public String getStatusTitle() {
        return statusTitle;
    }

    public void setStatusTitle(String statusTitle) {
        this.statusTitle = statusTitle;
    }

    @DynamoDBRangeKey
    public Collection<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Collection<Reservation> reservations) {
        this.reservations = reservations;
    }
}
