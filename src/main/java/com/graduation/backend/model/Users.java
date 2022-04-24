//package com.graduation.backend.model;
//
//import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.annotation.JsonInclude.Include;
//import com.fasterxml.jackson.annotation.JsonBackReference;
//import java.util.List;
//import lombok.*;
//
//import javax.persistence.*;
//
//
//@Entity
//@AllArgsConstructor
//@NoArgsConstructor
//@JsonInclude(Include.NON_NULL)
//public class Users {
//
//    @Id
//    @GeneratedValue
//    private Long id;
//
//    private String username;
//    private String password;
//    private String firstname;
//    private String lastname;
//    private String email;
//    private String street;
//    private int housenumber;
//    private String zipcode;
//    private String city;
////    private String favorites;
//    private Boolean enabled;
//    private String role;
//
//
//
//    @OneToMany(mappedBy = "users")
//    @JsonBackReference
//    private List<Users> users;
//
//
//    public Long getId() { return id; }
//    public void setId(Long id) { this.id = id; }
//
//    public String getUsername() { return username; }
//    public void setUsername(String username) { this.username = username; }
//
//    public String getPassword() { return password; }
//    public void setPassword(String password) { this.password = password; }
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
//    public Integer getHousenumber() { return housenumber; }
//    public void setHousenumber(Integer housenumber) { this.housenumber = housenumber; }
//
//    public String getZipcode() { return zipcode; }
//    public void setZipcode(String zipcode) { this.zipcode = zipcode; }
//
//    public String getCity() { return city; }
//    public void setCity(String city) { this.city = city; }
//
////    public String getFavorites() { return favorites; }
////    public void setFavorites(String favorites) { this.favorites = favorites; }
//
//    public String getRole() { return role; }
//    public void setRole(String role) { this.role = role; }
//
//    public Boolean getEnabled() { return enabled; }
//    public void setEnabled(Boolean enabled) { this.enabled = enabled; }
//
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
