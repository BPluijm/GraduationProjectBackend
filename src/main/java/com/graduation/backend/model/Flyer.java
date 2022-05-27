package com.graduation.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Flyer {

    @Id
    @GeneratedValue
    private Long id;

    @Lob
    @JsonIgnore
    private byte[] flyer;


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public byte[] getFlyer() { return flyer; }
    public void setFlyer(byte[] flyer) { this.flyer = flyer; }

}
