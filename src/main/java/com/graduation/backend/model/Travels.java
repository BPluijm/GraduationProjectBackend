package com.graduation.backend.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Travels {
    @Id
    @GeneratedValue
    Long id;

    String country;

    String travelType;

    // duration
    int travelTime;

    @OneToMany(mappedBy ="travels")
    List<Travels> travels;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(int travelTime) {
        this.travelTime = travelTime;
    }
}
