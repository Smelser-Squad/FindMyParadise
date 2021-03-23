package com.tp.wrc.findmyparadise.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "amenity")
public class Amenity implements Serializable {

    //VARIABLES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "amenity_id")
    private Integer amenity_id;

    private String amenity_name;
    private String amenity_category;

    //GETTERS & SETTERS
    public Integer getAmenity_id() {
        return amenity_id;
    }

    public void setAmenity_id(Integer amenity_id) {
        this.amenity_id = amenity_id;
    }

    public String getAmenity_name() {
        return amenity_name;
    }

    public void setAmenity_name(String amenity_name) {
        this.amenity_name = amenity_name;
    }

    public String getAmenity_category() {
        return amenity_category;
    }

    public void setAmenity_category(String amenity_category) {
        this.amenity_category = amenity_category;
    }

}
