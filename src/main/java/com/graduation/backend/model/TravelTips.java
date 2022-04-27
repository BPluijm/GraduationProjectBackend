package com.graduation.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;


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

    @NotBlank(message = "Please enter a name")
    String name;

    @NotBlank(message = "Please enter a country")
    String country;

    @NotBlank(message = "Please enter a city")
    String city;

    @NotBlank(message = "Please enter a description")
    String description;

    @Lob
    @JsonIgnore
    private byte[] folder;

    @OneToOne
    @JoinColumn(name = "future-travels-id")
    @JsonManagedReference(value = "future-travels-tip")
    private FutureTravels future;

}
