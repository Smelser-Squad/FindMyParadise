package com.tp.wrc.findmyparadise.controllers.requests;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.tp.wrc.findmyparadise.models.*;

import javax.persistence.*;

//import java.time.LocalDate;
import java.util.List;


public class AddListingRequest {


    private Integer listingID;
    private Integer hostID;
    private List<Integer> ruleID;
    private List<Integer> healthID;
    private Integer reservationID;
    private List<Integer> photoID;
    private List<Integer> amenityID;

    private String name;
    private Double latitude;
    private Double longitude;
    private String address;
    private String description;
    private Double price;
    private Integer maxGuests;
    private Double serviceFee;
    private Double occupancyFee;
    private Double cleaningFee;

    private Integer bedrooms;
    private Integer beds;
    private Integer bathrooms;
    private String type;
    private String checkIn;
    private String checkOut;



    public Integer getListingID() {
        return listingID;
    }

    public void setListingID(Integer listingID) {
        this.listingID = listingID;
    }

    public Integer getHostID() {
        return hostID;
    }

    public void setHostID(Integer hostID) {
        this.hostID = hostID;
    }

    public List<Integer> getRuleID() {
        return ruleID;
    }

    public void setRuleID(List<Integer> ruleID) {
        this.ruleID = ruleID;
    }

    public List<Integer> getHealthID() {
        return healthID;
    }

    public void setHealthID(List<Integer> healthID) {
        this.healthID = healthID;
    }

    public Integer getReservationID() {
        return reservationID;
    }

    public void setReservationID(Integer reservationID) {
        this.reservationID = reservationID;
    }

    public List<Integer> getPhotoID() {
        return photoID;
    }

    public void setPhotoID(List<Integer> photoID) {
        this.photoID = photoID;
    }

    public List<Integer> getAmenityID() {
        return amenityID;
    }

    public void setAmenityID(List<Integer> amenityID) {
        this.amenityID = amenityID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getMaxGuests() {
        return maxGuests;
    }

    public void setMaxGuests(Integer maxGuests) {
        this.maxGuests = maxGuests;
    }

    public Double getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(Double serviceFee) {
        this.serviceFee = serviceFee;
    }

    public Double getOccupancyFee() {
        return occupancyFee;
    }

    public void setOccupancyFee(Double occupancyFee) {
        this.occupancyFee = occupancyFee;
    }

    public Double getCleaningFee() {
        return cleaningFee;
    }

    public void setCleaningFee(Double cleaningFee) {
        this.cleaningFee = cleaningFee;
    }


    public Integer getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(Integer bedrooms) {
        this.bedrooms = bedrooms;
    }

    public Integer getBeds() {
        return beds;
    }

    public void setBeds(Integer beds) {
        this.beds = beds;
    }

    public Integer getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(Integer bathrooms) {
        this.bathrooms = bathrooms;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

}
