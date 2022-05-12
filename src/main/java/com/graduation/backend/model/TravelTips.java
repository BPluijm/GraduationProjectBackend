package com.graduation.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import javax.persistence.*;



@Entity
@NoArgsConstructor
@AllArgsConstructor
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
    private byte[] file;


//    @Entity
//    public class Image {
//        @Id
//        @GeneratedValue
//        Long id;
//
//        @Lob
//        public byte[] content;
//    }




//    @JsonBackReference(value = "add pdf")
//    private TravelTips addPdf;


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
