package com.graduation.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import javax.persistence.*;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "travel_tips")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TravelTips {

    @Id
    @GeneratedValue
    Long id;
    String name;
    String country;
    String city;
    String description;

    @Lob
    @JsonIgnore
    private byte[] folder;

    @OneToOne
    @JoinColumn(name = "future-travels-id")
    @JsonManagedReference(value = "future-travels-tip")
    private FutureTravels future;

}
