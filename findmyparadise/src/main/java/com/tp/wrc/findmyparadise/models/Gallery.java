package com.tp.wrc.findmyparadise.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Gallery")
public class Gallery implements Serializable {

    //VARIABLES

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "image_id")
    private Integer imageId;

    @Column(name = "image_src", nullable = false)
    private String imageSrc;


    //TODO: connect listing id to listing
    //TODO: may need bridge table?

    @Column(name = "listing_id", nullable = false)
    private Integer listingId;

    @Column(name = "category", nullable = false)
    private String category;

    public Gallery(){

    }


    public Integer getImageId() { return imageId;}

    public void setImageId(Integer imageId) {this.imageId = imageId; }

    public String getImageSrc() {return imageSrc; }

    public void setImageSrc(String imageSrc) {this.imageSrc = imageSrc; }

    public Integer getListingId() { return listingId; }

    public void setListingId(Integer listingId) { this.listingId = listingId; }

    public String getCategory() { return category; }

    public void setCategory(String category) { this.category = category; }
}
