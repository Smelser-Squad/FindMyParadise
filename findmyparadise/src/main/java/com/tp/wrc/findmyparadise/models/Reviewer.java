package com.tp.wrc.findmyparadise.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "reviewer")
public class Reviewer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "reviewer_id")
    private Integer reviewerId;

    @Column(name = "name")
    private String name;

    @Column(name = "image_src")
    private String imageSrc;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_review")
    List<Review> reviews = new ArrayList<>();

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

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
