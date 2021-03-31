package com.tp.wrc.findmyparadise.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "reviewer")
public class Reviewer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reviewer_id")
    private Integer reviewerId;

    @Column(name = "name")
    private String name;

    @Column(name = "image_src")
    private String imageSrc;

    @Column(name = "rating_description")
    private String description;

    @Column(name = "joined_date")
    private LocalDate joinedDate;

//    @OneToMany(mappedBy = "reviewer")
//    private Set<Review> reviews;
//    public Reviewer(){
//
//    }

    public Reviewer() {

    }
    public Reviewer(String imageSrc, String description, LocalDate joinedDate, String name){
        this.name = name;
        this.imageSrc = imageSrc;
        this.description = description;
        this.joinedDate = joinedDate;

    }

    public Integer getReviewerId() {
        return reviewerId;
    }

    public void setReviewerId(Integer reviewerId) {
        this.reviewerId = reviewerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }

//    public Set<Review> getReviews() {
//        return reviews;
//    }
//
//    public void setReviews(Set<Review> reviews) {
//        this.reviews = reviews;
//    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(LocalDate joinedDate) {
        this.joinedDate = joinedDate;
    }
}
