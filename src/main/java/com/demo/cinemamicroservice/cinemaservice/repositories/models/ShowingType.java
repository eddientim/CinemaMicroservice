package com.demo.cinemamicroservice.cinemaservice.repositories.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.List;

@DynamoDBTable(tableName = "showing_type")
public class ShowingType {

    private String title;
    private List<CinemaShowing> cinemaShowings;

    protected ShowingType() {
    }

    public ShowingType(String title) {
        this.title = title;
    }

    public ShowingType(String title, List<CinemaShowing> cinemaShowings) {
        this.title = title;
        this.cinemaShowings = cinemaShowings;
    }

    @DynamoDBAttribute
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @DynamoDBAttribute
    public List<CinemaShowing> getCinemaShowings() {
        return cinemaShowings;
    }

    public void setCinemaShowings(List<CinemaShowing> cinemaShowings) {
        this.cinemaShowings = cinemaShowings;
    }
}
