package com.graduation.backend.model;

import javax.persistence.*;
import java.util.List;

@Entity
//@Table(name = "travels")
public class Travels {
    @Id
    @GeneratedValue
    Long id;

    int startYear;
    String country;
    String city;
    String travelType;
    String description;
    int travelTime;

    @OneToMany(mappedBy ="travels")
    List<Travels> travels;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTravelType() {
        return travelType;
    }

    public void setTravelType(String travelType) {
        this.travelType = travelType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(int travelTime) {
        this.travelTime = travelTime;
    }
}
