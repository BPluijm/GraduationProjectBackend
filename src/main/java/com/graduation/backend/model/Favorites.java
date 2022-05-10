package com.graduation.backend.model;


import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.*;

import javax.persistence.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
public class Favorites {

        @Id
        @GeneratedValue
        private Long id;

        @OneToOne
        @PrimaryKeyJoinColumn(name= "travels_id")
        Travels travels;


//        @OneToOne
//        @JoinColumn(name = "favorites_id")
//        @JsonManagedReference(value = "users")
//        private Users users;
//
//        @OneToOne
//        @JoinColumn(name = "favorites_id")
//        @JsonManagedReference(value = "travels")
//        private Travels travels;


        public Long getId() {
                return id;
        }
        public void setId(Long id) {
                this.id = id;
        }

        public Travels getTravels() {
                return travels;
        }
        public void setTravels(Travels travels) {
                this.travels = travels;
        }
}
