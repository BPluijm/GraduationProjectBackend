package com.graduation.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.*;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
@Table(name = "future_travels")
public class FutureTravels {

    @Id
    @GeneratedValue
    private Long id;

    private String country;
    private String area;
    private String category;
    private int duration;
    private int costs;

//    @OneToOne(mappedBy = "future")
//    @JsonBackReference(value = "future-travels-tips")
//    private TravelTips tips;

//
//    public List<TravelTips> getFutureTravelTips() {
//    }

//    @ManyToOne
//    @JsonBackReference(value = "users-tip")
//    @JoinColumn(name = "users_id")
//    private List<Users> users;


}
