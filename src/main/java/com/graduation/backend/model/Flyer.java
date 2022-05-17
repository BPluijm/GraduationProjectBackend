package com.graduation.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "flyer")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Flyer {

    @Id
    @GeneratedValue
    private Long id;

    @Lob
    @JsonIgnore
    private byte[] flyer;

//    @OneToOne
//    @JoinColumn(name = "travel_tip_id")
//    @JsonManagedReference(value = "flyer-travel-tips")
//    private TravelTips travelTips;


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public byte[] getFlyer() { return flyer; }
    public void setFlyer(byte[] flyer) { this.flyer = flyer; }
}
