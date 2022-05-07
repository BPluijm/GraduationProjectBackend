//package com.graduation.backend.dto;
//
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.annotation.JsonInclude.Include;
//import lombok.*;
//
//import javax.validation.constraints.*;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@JsonInclude(Include.NON_NULL)
//public class HotSpotsDto {
//    private Long id;
//
//    @NotBlank(message = "Please enter a suitable name")
//    private String name;
//
//    @NotBlank(message = "Please enter a country")
//    private String country;
//
//    @NotBlank(message = "Please enter a city")
//    private String city;
//
//    @JsonIgnore
//    private byte[] flyer;
//
////    @OneToOne
////    @JoinColumn(name = "users_id")
////    @JsonManagedReference(value = "users-hotspots")
////    private Users users;
//
//}
