package com.graduation.backend.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@JsonInclude(Include.NON_NULL)
public class Users {

    @Id
    @GeneratedValue
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
//    private String favorites;
    private String role;

//    @OneToMany(mappedBy = "users")
//    @JsonBackReference
//    private List<Users> users;

}













