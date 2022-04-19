package com.graduation.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
//@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue
    private Long id;

    private String firstname;
    private String lastname;
    private String email;
    private String street;
    private Integer houseNumber;
    private String zipcode;
    private String city;
    private String preferences;

    @OneToMany(mappedBy = "users")
    @JsonBackReference
    private List<Users> users;

}