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

        @JsonIgnore
        @ManyToOne(fetch = FetchType.LAZY)
        Travels travels;

        @JsonIgnore
        @ManyToOne(fetch = FetchType.LAZY)
        Users users;



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

        public Users getUsers() { return users; }
        public void setUsers(Users users) { this.users = users; }
}
