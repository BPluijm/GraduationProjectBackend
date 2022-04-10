package com.graduation.backend.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TravelTips")
public class TravelTips {
    @Id
    @GeneratedValue
    Long id;

    String name;

    String country;

    String city;

    String description;

    // hier moet nog een upload functie komen


    @OneToMany(mappedBy = "travelTips")
    List<TravelTips> travelTips;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

}
