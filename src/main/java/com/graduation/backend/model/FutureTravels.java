package com.graduation.backend.model;

import com.graduation.backend.dto.FutureTravelsDto;
import javax.persistence.*;
import java.util.List;

@Entity
//@Table(name = "future_travels")
public class FutureTravels {
    @Id
    @GeneratedValue
    Long id;

    String country;

    String cities;

    String travelType;

    int travelTime;

    int expectedCosts;

    @OneToMany(mappedBy = "FutureTravels")
    List<FutureTravels> FutureTravels;

    public static void add(FutureTravelsDto ftdto) {
    }

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

    public String getCities() {
        return cities;
    }

    public void setCities(String travelType) {
        this.cities = travelType;
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

    public int getExpectedCosts() {
        return expectedCosts;
    }

    public void setExpectedCosts(int expectedCosts) {
        this.expectedCosts = expectedCosts;
    }

}
