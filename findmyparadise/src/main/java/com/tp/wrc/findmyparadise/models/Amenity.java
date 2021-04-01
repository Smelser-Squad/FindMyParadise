package com.tp.wrc.findmyparadise.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "amenity")
@JsonIgnoreProperties(value = {"listings"}, allowSetters = true)
public class Amenity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "amenity_id")
    private Integer amenityId;

    @Column(name = "amenity_name", nullable = false)
    private String amenityName;

    @Column(name = "amenity_category", nullable = false)
    private String category;

    @ManyToMany(mappedBy = "amenities", cascade = CascadeType.ALL)
    private Set<Listing> listings;

    public Amenity(){}

    public Amenity(Integer amenityId, String amenityName, String amenityCategory) {
        this.amenityId = amenityId;
        this.amenityName = amenityName;
        this.category = amenityCategory;
    }

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

    public Set<Listing> getListings() {
        return listings;
    }

    public void setListings(Set<Listing> listings) {
        this.listings = listings;
    }

}
