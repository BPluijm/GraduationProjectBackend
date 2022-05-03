package com.graduation.backend.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "travels")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Travels {
    @Id
    @GeneratedValue
    private Long id;

    private String country;
    private int years;
    private String city;
    private String category;
    private String description;
    private int duration;

//    @OneToMany(mappedBy = "travels")
//    @JsonManagedReference(value = "travels-favorites")
//    private List<Favorites> favorites;

}
