package com.graduation.backend.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Travels {

    @Id
    @GeneratedValue
    @JoinColumn(name = "travels_id")
    private Long id;

    private String country;
    private int years;
    private String city;
    private String category;
    private String description;
    private int duration;

    @OneToMany
    //    @PrimaryKeyJoinColumn(name = "favorites_id")
    List<Favorites> favorites;

    @ManyToOne
//    @PrimaryKeyJoinColumn(name = "users_id")
    Users users;


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

    public String getCategory() { return category; }
    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() { return description; }
    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration() { return duration; }
    public void setDuration(int duration) {
        this.duration = duration;
    }

    public List<Favorites> getFavorites() { return favorites; }
    public void setFavorites(List<Favorites> favorites) { this.favorites = favorites; }

    public Users getUsers() { return users; }
    public void setUsers(Users users) { this.users = users; }


}
