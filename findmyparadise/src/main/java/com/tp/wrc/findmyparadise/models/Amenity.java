package com.tp.wrc.findmyparadise.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "amenity")
public class Amenity implements Serializable {

    //VARIABLES
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "amenity_id")
    private Integer amenityId;

    @Column(name = "amenity_name", nullable = false)
    private String amenityName;

    @Column(name = "category", nullable = false)
    private String category;

    //CONSTRUCTORS
    public Amenity(){}

    public Amenity(Integer amenityId, String amenityName, String amenityCategory) {
        this.amenityId = amenityId;
        this.amenityName = amenityName;
        this.category = amenityCategory;
    }

    //GETTERS & SETTERS
    public Integer getAmenityId() {
        return amenityId;
    }

    public void setAmenityId(Integer amenityId) {
        this.amenityId = amenityId;
    }

    public String getAmenityName() {
        return amenityName;
    }

    public void setAmenityName(String amenityName) {
        this.amenityName = amenityName;
    }

    public String getAmenityCategory() {
        return category;
    }

    public void setAmenityCategory(String amenityCategory) {
        this.category = amenityCategory;
    }

}
