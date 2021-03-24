package com.tp.wrc.findmyparadise.models;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name ="Reviews")
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

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "reviewer_id")
    private Reviewer reviewer;

    public Review(){

    }

    public Review(Integer reviewId, Integer rating, Integer cleanlinessRating, Integer locationRating, Integer accuracyRating,
                  Integer valueRating, Integer checkInRating, Integer communicationRating, String reviewText, LocalDate joinedDate, Reviewer reviewer){

        this.reviewId = reviewId;
        this.rating = rating;
        this.cleanlinessRating = cleanlinessRating;
        this.locationRating = locationRating;
        this.accuracyRating = accuracyRating;
        this.valueRating = valueRating;
        this.checkInRating = checkInRating;
        this.communicationRating = communicationRating;
        this.reviewText = reviewText;
        this.reviewer = reviewer;
    }

    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getCleanlinessRating() {
        return cleanlinessRating;
    }

    public void setCleanlinessRating(Integer cleanlinessRating) {
        this.cleanlinessRating = cleanlinessRating;
    }

    public Integer getLocationRating() {
        return locationRating;
    }

    public void setLocationRating(Integer locationRating) {
        this.locationRating = locationRating;
    }

    public Integer getAccuracyRating() {
        return accuracyRating;
    }

    public void setAccuracyRating(Integer accuracyRating) {
        this.accuracyRating = accuracyRating;
    }

    public Integer getValueRating() {
        return valueRating;
    }

    public void setValueRating(Integer valueRating) {
        this.valueRating = valueRating;
    }

    public Integer getCheckInRating() {
        return checkInRating;
    }

    public void setCheckInRating(Integer checkInRating) {
        this.checkInRating = checkInRating;
    }

    public Integer getCommunicationRating() {
        return communicationRating;
    }

    public void setCommunicationRating(Integer communicationRating) {
        this.communicationRating = communicationRating;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public LocalDate getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(LocalDate joinedDate) {
        this.joinedDate = joinedDate;
    }

    public Reviewer getReviewer() {
        return reviewer;
    }

    public void setReviewer(Reviewer reviewer) {
        this.reviewer = reviewer;
    }
}
