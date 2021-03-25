package com.tp.wrc.findmyparadise.models;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "event")
public class Event {

    // V A R I A B L E S

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //Primary Key, Cannot be null

    private String title;
    private String summary;
    private String category;
    private double cost;
    private double latitude;
    private double longitude;


    // C O N S T R U C T O R S
    public Event() {

    }

    public Event(String title, String summary, String category, double cost, double latitude, double longitude) {
        this.title = title;
        this.summary = summary;
        this.category = category;
        this.cost = cost;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // M E T H O D S

    // G E T T E R S && S E T T E R S
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    // HASH & EQUALS


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Double.compare(event.cost, cost) == 0 && Double.compare(event.latitude, latitude) == 0 && Double.compare(event.longitude, longitude) == 0 && id.equals(event.id) && Objects.equals(title, event.title) && Objects.equals(summary, event.summary) && Objects.equals(category, event.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, summary, category, cost, latitude, longitude);
    }
}
