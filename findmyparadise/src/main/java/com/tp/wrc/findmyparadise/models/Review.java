package com.tp.wrc.findmyparadise.models;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table
public class Review implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "review_id")
    private Integer reviewId;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "cleanlinessRating")
    private Integer cleanlinessRating;

    @Column(name = "locationRating")
    private Integer locationRating;

    @Column(name = "accuracyRating")
    private Integer accuracyRating;

    @Column(name = "valueRating")
    private Integer valueRating;

    @Column(name = "checkInRating")
    private Integer checkInRating;

    @Column(name = "communicationRating")
    private Integer communicationRating;

    @Column(name = "reviewText")
    private String reviewText;

    @Column(name = "joinedDate")
    private LocalDate joinedDate;


    public Review(){

    }

    public Review(Integer reviewId, Integer rating, Integer cleanlinessRating, Integer locationRating, Integer accuracyRating,
                  Integer valueRating, Integer checkInRating, Integer communicationRating, String reviewText, LocalDate joinedDate){

        this.reviewId = reviewId;
        this.rating = rating;
        this.cleanlinessRating = cleanlinessRating;
        this.locationRating = locationRating;
        this.accuracyRating = accuracyRating;
        this.valueRating = valueRating;
        this.checkInRating = checkInRating;
        this.communicationRating = communicationRating;
        this.reviewText = reviewText;
        this.joinedDate = joinedDate;
    }


}
