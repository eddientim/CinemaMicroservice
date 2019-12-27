//package com.demo.cinemamicroservice.cinemaservice.models;
//
//import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
//import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
//
//@DynamoDBTable(tableName = "news")
//public class News extends BaseModel {
//
//    private String title;
//    private String contentText;
//    private String imageUrl;
//    private Date datePublished;
//    private CinemaShowing cinemaShowing;
//
//    protected News() {
//    }
//
//    public News(String title, String contentText, String imageUrl, Date datePublished, CinemaShowing cinemaShowing) {
//        this.title = title;
//        this.contentText = contentText;
//        this.imageUrl = imageUrl;
//        this.datePublished = datePublished;
//        this.cinemaShowing = cinemaShowing;
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
//    public String getContentText() {
//        return contentText;
//    }
//
//    public void setContentText(String contentText) {
//        this.contentText = contentText;
//    }
//
//    @DynamoDBAttribute
//    public String getImageUrl() {
//        return imageUrl;
//    }
//
//    public void setImageUrl(String imageUrl) {
//        this.imageUrl = imageUrl;
//    }
//
//    @DynamoDBAttribute
//    public Date getDatePublished() {
//        return datePublished;
//    }
//
//    public void setDatePublished(Date datePublished) {
//        this.datePublished = datePublished;
//    }
//
//    @DynamoDBAttribute
//    public CinemaShowing getCinemaShowing() {
//        return cinemaShowing;
//    }
//
//    public void setCinemaShowing(CinemaShowing cinemaShowing) {
//        this.cinemaShowing = cinemaShowing;
//    }
//}
