package com.graduation.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "hotspots")
@JsonInclude(Include.NON_NULL)
public class HotSpots {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String country;
    private String area;

    @Lob
    @JsonIgnore
    private byte[] folder;
}
