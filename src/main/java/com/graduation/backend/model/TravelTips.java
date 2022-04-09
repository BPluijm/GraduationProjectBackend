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

    String remark;

    // hier moet nog een upload functie komen


    @OneToMany(mappedBy = "TravelTips")
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

    public void setName(String country) {
        this.name = country;
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

    public String getRemark() { return remark; }

    public void setRemark(String remark) { this.remark = remark; }

}
