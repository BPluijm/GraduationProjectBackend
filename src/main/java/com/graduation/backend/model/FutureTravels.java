package com.graduation.backend.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class FutureTravels {
    @Id
    @GeneratedValue
    Long id;

    String country;

    String area;

    String category;

    int duration;

    int costs;


    @OneToMany(mappedBy = "FutureTravels")
    List<FutureTravels> FutureTravels;

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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getCosts() {
        return costs;
    }

    public void setCosts(int costs) {
        this.costs = costs;
    }

}
