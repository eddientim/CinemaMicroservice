package com.demo.cinemamicroservice.cinemaservice.repositories.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.Collection;
import java.util.List;

@DynamoDBTable(tableName = "reservation_status")
public class ReservationStatus {

    private String statusTitle;
    private List<Reservations> reservations;

    protected ReservationStatus() {
    }

    public ReservationStatus(String statusTitle, List<Reservations> reservations) {
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

    @DynamoDBAttribute
    public Collection<Reservations> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservations> reservations) {
        this.reservations = reservations;
    }
}
