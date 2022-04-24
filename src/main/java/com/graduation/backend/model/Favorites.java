package com.graduation.backend.model;


import com.fasterxml.jackson.annotation.JsonInclude;
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

        private Boolean add;

        private Boolean remove;



}
