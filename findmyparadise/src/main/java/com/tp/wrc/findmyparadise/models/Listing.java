package com.tp.wrc.findmyparadise.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "listing")
public class Listing implements Serializable {
    @Id
    @Column(name = "listing_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer listingId;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "latitude")
    private Double latitude;
    @Column(name = "longitude")
    private Double longitude;
    @ManyToOne
    @JoinColumn(name = "host_id")
    private Host host;
    @Column(name = "address", nullable = false)
    private String address;
    @Column(name = "description")
    private String description;
    @Column(name = "price", nullable = false)
    private Double price;
    @Column(name = "max_guests")
    private Integer maxGuests;
    @Column(name = "service_fee")
    private Double serviceFee;
    @Column(name = "occupancy_fee")
    private Double occupancyFee;
    @Column(name = "cleaning_fee")
    private Double cleaningFee;
    @OneToMany(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            mappedBy = "listing",
            orphanRemoval = true)
    @JsonManagedReference
    private Set<Review> reviews = new HashSet<>();
    @OneToMany(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            mappedBy = "listing",
            orphanRemoval = true)
    @JsonManagedReference
    private Set<Reservation> reservations = new HashSet<>();
    @OneToMany(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            mappedBy = "listing",
            orphanRemoval = true)
    @JsonManagedReference
    private Set<Photo> photos = new HashSet<>();
    @Column(name= "bedroom_quantity")
    private Integer bedrooms;
    @Column(name= "beds_quantity")
    private Integer beds;
    @Column(name= "bathroom_quantity")
    private Integer bathrooms;
    @Column (name ="listing_type")
    private String type;


    @Column (name ="check_in")
    private String checkIn;

    @Column (name ="check_out")
    private String checkOut;


    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(
            name = "listing_amenities",
            joinColumns = @JoinColumn(name = "listing_id"),
            inverseJoinColumns = @JoinColumn(name = "amenity_id"))
    private Set<Amenity> amenities = new HashSet<>();



    @ManyToMany(cascade = CascadeType.MERGE)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(
            name="listing_rules",
            joinColumns = @JoinColumn(name = "listing_id"),
            inverseJoinColumns = @JoinColumn(name = "rule_id"))
    private List<Rules> rules = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.MERGE)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(
            name="listing_health",
            joinColumns = @JoinColumn(name = "listing_id"),
            inverseJoinColumns = @JoinColumn(name = "health_id"))
    private List<Health> healthRules = new ArrayList<>();

    public Listing() {
    }
    public Integer getListingId() {
        return listingId;
    }
    public void setListingId(Integer listingId) {
        this.listingId = listingId;
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

    public Set<Amenity> getAmenities() {
        return amenities;
    }
    public void setAmenities(Set<Amenity> amenities) {
        this.amenities = amenities;
    }
    public Set<Photo> getPhotos() {
        return photos;
    }
    public void setPhotos(Set<Photo> photos) {
        this.photos = photos;
    }

    public List<Rules> getRules() {
        return rules;
    }

    public void setRules(List<Rules> rules) {
        this.rules = rules;
    }

    public List<Health> getHealthRules() {
        return healthRules;
    }

    public void setHealthRules(List<Health> healthRules) {
        this.healthRules = healthRules;
    }
}

