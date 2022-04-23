//package com.graduation.backend.model;
//
//import com.fasterxml.jackson.annotation.JsonBackReference;
//import lombok.*;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
//@AllArgsConstructor
//@NoArgsConstructor
////@Table(name = "users")
//public class Users {
//
//    @Id
//    @GeneratedValue
//    private Long id;
//    private String firstname;
//    private String lastname;
//    private String email;
//    private String street;
//    private int houseNumber;
//    private String zipcode;
//    private String city;
//    private String favorites;
//
//    @OneToMany(mappedBy = "users")
//    @JsonBackReference
//    private List<Users> users;
//
//
//    public Long getId() { return id; }
//    public void setId(Long id) { this.id = id; }
//
//    public String getFirstname() { return firstname; }
//    public void setFirstname(String firstname) { this.firstname = firstname; }
//
//    public String getLastname() { return lastname; }
//    public void setLastname(String lastname) { this.lastname = lastname; }
//
//    public String getEmail() { return email; }
//    public void setEmail(String email) { this.email = email; }
//
//    public String getStreet() { return street; }
//    public void setStreet(String street) { this.street = street; }
//
//    public Integer getHouseNumber() { return houseNumber; }
//    public void setHouseNumber(Integer houseNumber) { this.houseNumber = houseNumber; }
//
//    public String getZipcode() { return zipcode; }
//    public void setZipcode(String zipcode) { this.zipcode = zipcode; }
//
//    public String getCity() { return city; }
//    public void setCity(String city) { this.city = city; }
//
//    public String getFavorites() { return favorites; }
//    public void setFavorites(String favorites) { this.favorites = favorites; }
//
//}