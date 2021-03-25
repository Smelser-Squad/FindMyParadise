package com.tp.wrc.findmyparadise.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

//    @OneToMany(mappedBy = "reviewer")
//    private Set<Review> reviews;
//    public Reviewer(){
//
//    }

    public Reviewer() {

    }
    public Reviewer(String name, String imageSrc, String description){
        this.name = name;
        this.imageSrc = imageSrc;
        this.description = description;

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
}
