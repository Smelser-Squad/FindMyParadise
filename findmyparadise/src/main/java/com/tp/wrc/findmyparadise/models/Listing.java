package com.tp.wrc.findmyparadise.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "listing")
public class Listing {
    @Id
    @Column(name = "listing_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer listingID;

    @Column(name = "name")
    private String name;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "host_id", nullable = false)
    private Host host;

    @Column(name = "address")
    private String address;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Double price;

    @Column(name = "max_guests")
    private Integer maxGuests;

    @Column(name = "service_fee")
    private Double serviceFee;

    @Column(name = "occupancy_fee")
    private Double occupancyFee;

    @Column(name = "cleaning_fee")
    private Double cleaningFee;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "listing_id")
    private Set<Review> reviews;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "listing_id")
    private Set<Reservation> reservations;

    public Listing() {

    }

    public Integer getListingID() {
        return listingID;
    }

    public void setListingID(Integer listingID) {
        this.listingID = listingID;
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
    public Host getHost() {
        return host;
    }

    public void setHost(Host host) {
        this.host = host;
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

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }
}
