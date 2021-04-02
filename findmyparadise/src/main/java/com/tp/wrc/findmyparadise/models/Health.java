package com.tp.wrc.findmyparadise.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "health_safety")
public class Health implements Serializable {

    @Id
    @Column(name = "health_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer healthId;

    @Column(name = "health_name")
    private String healthName;

    @Column(name = "health_value")
    private String healthValue;

    @ManyToMany(mappedBy = "healthRules", cascade = CascadeType.ALL)
    private Set<Listing> listings;

    public Health()
    {

    }

    public Health(Integer healthId, String healthName, String healthValue, Set<Listing> listings) {
        this.healthId = healthId;
        this.healthName = healthName;
        this.healthValue = healthValue;
        this.listings = listings;
    }

    public Integer getHealthId() {
        return healthId;
    }

    public void setHealthId(Integer healthId) {
        this.healthId = healthId;
    }

    public String getHealthName() {
        return healthName;
    }

    public void setHealthName(String healthName) {
        this.healthName = healthName;
    }

    public String getHealthValue() {
        return healthValue;
    }

    public void setHealthValue(String healthValue) {
        this.healthValue = healthValue;
    }

    public Set<Listing> getListings() {
        return listings;
    }

    public void setListings(Set<Listing> listings) {
        this.listings = listings;
    }
}
