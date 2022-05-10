package com.graduation.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;


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


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public byte[] getFile() { return file; }
    public void setFile(byte[] file) { this.file = file; }
}
