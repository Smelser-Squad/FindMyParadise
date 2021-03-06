package com.tp.wrc.findmyparadise.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name ="review")
@JsonIgnoreProperties(value = {"listings"}, allowSetters = true)
public class Review implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Integer reviewId;
    @Column(name = "rating")
    private Integer rating;
    @Column(name = "cleanliness_rating")
    private Integer cleanlinessRating;
    @Column(name = "location_rating")
    private Integer locationRating;
    @Column(name = "accuracy_rating")
    private Integer accuracyRating;
    @Column(name = "value_rating")
    private Integer valueRating;
    @Column(name = "check_in_rating")
    private Integer checkInRating;
    @Column(name = "communication_rating")
    private Integer communicationRating;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_reviewer_id", referencedColumnName = "reviewer_id", nullable = false)
    private Reviewer reviewer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "listing_id")
    @JsonBackReference
    private Listing listing;


    public Review(){}
    public Review(Integer rating, Integer cleanlinessRating, Integer locationRating, Integer accuracyRating,
                  Integer valueRating, Integer checkInRating, Integer communicationRating, Reviewer reviewer){
        this.rating = rating;
        this.cleanlinessRating = cleanlinessRating;
        this.locationRating = locationRating;
        this.accuracyRating = accuracyRating;
        this.valueRating = valueRating;
        this.checkInRating = checkInRating;
        this.communicationRating = communicationRating;
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

    public Reviewer getReviewer() {
        return reviewer;
    }
    public void setReviewer(Reviewer reviewer) {
        this.reviewer = reviewer;
    }

    public Listing getListing() {
        return listing;
    }

    public void setListing(Listing listing) {
        this.listing = listing;
    }
}