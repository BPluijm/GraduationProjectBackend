package com.graduation.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    String name;
    String country;
    String city;
    String description;

//    @JsonBackReference(value = "add pdf")
//    private TravelTips addPdf;
    @Lob
    @JsonIgnore
    private byte[] file;

//    @OneToOne
//    @JoinColumn(name = "future-travels-id")
//    @JsonManagedReference(value = "future-travels-tip")
//    private FutureTravels futu;
//
//    public void setFutureTravels(FutureTravels futu) {
//    }
}
