package com.graduation.backend.model;


import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.*;

import javax.persistence.*;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
public class Favorites {

        @Id
        @GeneratedValue
        private Long id;

//        @OneToOne
//        @JoinColumn(name = "favorites_id")
//        @JsonManagedReference(value = "users")
//        private Users users;
//
//        @OneToOne
//        @JoinColumn(name = "favorites_id")
//        @JsonManagedReference(value = "travels")
//        private Travels travels;



}
