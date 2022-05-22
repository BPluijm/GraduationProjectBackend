package com.graduation.backend.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class Users {

    @Id
    @GeneratedValue
    @JoinColumn(name = "users_id")
    private Long id;

    private String username;
    private String password;
    private Boolean enabled;
    private String firstname;
    private String lastname;
    private String email;
    private String street;
    private int housenumber;
    private String zipcode;
    private String city;
    private String role;

    @OneToMany
    private List<Favorites> favorites;

    @OneToMany
    private List<TravelTips> travelTips;


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Boolean getEnabled() { return enabled; }
    public void setEnabled(Boolean enabled) { this.enabled = enabled; }

    public String getFirstname() { return firstname; }
    public void setFirstname(String firstname) { this.firstname = firstname; }

    public String getLastname() { return lastname; }
    public void setLastname(String lastname) { this.lastname = lastname; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }

    public int getHousenumber() { return housenumber; }
    public void setHousenumber(int housenumber) { this.housenumber = housenumber; }

    public String getZipcode() { return zipcode; }
    public void setZipcode(String zipcode) { this.zipcode = zipcode; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public List<Favorites> getFavorites() { return favorites; }
    public void setFavorites(List<Favorites> favorites) { this.favorites = favorites; }

    public List<TravelTips> getTravelTips() { return travelTips; }
    public void setTravelTips(List<TravelTips> travelTips) { this.travelTips = travelTips; }

}













