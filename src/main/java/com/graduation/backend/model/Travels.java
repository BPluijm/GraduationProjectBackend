package com.graduation.backend.model;

import javax.persistence.*;
import java.util.List;

@Entity
//@Table(name = "travels")
public class Travels {
    @Id
    @GeneratedValue
    Long id;

    String country;

    int years;

    String city;

    String category;

    String description;

    int duration;

    @OneToMany(mappedBy ="Travels")
    List<Travels> Travels;

//    @OneToMany(mappedBy = "travels")
//    @JsonManagedReference(value = "travels-favorites")
//    private List<Favorites> favorites;



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

    public int getYears() {
        return years;
    }
    public void setYears(int years) {
        this.years = years;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
}
