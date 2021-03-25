package com.tp.wrc.findmyparadise.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "host")
public class Host implements Serializable {

    // VARIABLES

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "host_id")
    private Integer hostID; // PK NOT NULL

    @Column(name = "host_name", nullable = false)
    private String hostName;

    @Column(name = "total_reviews", nullable = false)
    private String totalReviews;

    @Column(name = "super_host", nullable = false)
    private boolean superHost;

    @Column(name = "verified", nullable = false)
    private boolean verified;

    @Column(name = "response_time", nullable = false)
    private String responseTime;

    @Column(name = "response_rate", nullable = false)
    private Double responseRate;

    @Column(name = "join_date", nullable = false)
    private String joinDate;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "image_src", nullable = false)
    private String imageSrc;

    @OneToMany(mappedBy = "host")
    private Set<Listing> listings;

    // EMPTY CONSTRUCTOR

    public Host() {


    }

    // CONSTRUCTOR


    public Host(Integer hostID, String hostName, String totalReviews, boolean superHost, boolean verified,
                String responseTime, Double responseRate, String joinDate, String email, String imageSrc) {
        this.hostID = hostID;
        this.hostName = hostName;
        this.totalReviews = totalReviews;
        this.superHost = superHost;
        this.verified = verified;
        this.responseTime = responseTime;
        this.responseRate = responseRate;
        this.joinDate = joinDate;
        this.email = email;
        this.imageSrc = imageSrc;
    }

    // GETTERS AND SETTERS


    public Integer getHostID() {
        return hostID;
    }

    public void setHostID(Integer hostID) {
        this.hostID = hostID;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getTotalReviews() {
        return totalReviews;
    }

    public void setTotalReviews(String totalReviews) {
        this.totalReviews = totalReviews;
    }

    public boolean isSuperHost() {
        return superHost;
    }

    public void setSuperHost(boolean superHost) {
        this.superHost = superHost;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public String getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(String responseTime) {
        this.responseTime = responseTime;
    }

    public Double getResponseRate() {
        return responseRate;
    }

    public void setResponseRate(Double responseRate) {
        this.responseRate = responseRate;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }


}

