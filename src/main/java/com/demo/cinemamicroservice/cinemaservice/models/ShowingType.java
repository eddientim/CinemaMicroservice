//package com.demo.cinemamicroservice.cinemaservice.models;
//
//import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
//import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//import java.util.Collection;
//
//@DynamoDBTable(tableName = "showing_type")
//public class ShowingType extends BaseModel {
//
//
//    private String title;
//    private Collection<CinemaShowing> cinemaShowings;
//
//    protected ShowingType() {
//    }
//
//    public ShowingType(String title) {
//        this.title = title;
//    }
//
//    public ShowingType(String title, Collection<CinemaShowing> cinemaShowings) {
//        this.title = title;
//        this.cinemaShowings = cinemaShowings;
//    }
//
//    @DynamoDBAttribute
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    @DynamoDBAttribute
//    @JsonIgnore
//    public Collection<CinemaShowing> getCinemaShowings() {
//        return cinemaShowings;
//    }
//
//    public void setCinemaShowings(Collection<CinemaShowing> cinemaShowings) {
//        this.cinemaShowings = cinemaShowings;
//    }
//}
