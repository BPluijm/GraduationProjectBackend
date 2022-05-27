package com.graduation.backend.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.graduation.backend.model.Favorites;
import com.graduation.backend.model.Users;
import lombok.*;
import javax.validation.constraints.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class TravelsDto {
    private Long id;

    @NotBlank(message = "Please enter a country")
    private String country;

    @NotNull(message = "Please enter the year you were there")
    private int years;

    @NotBlank(message = "Please enter a city")
    private String city;

    @NotBlank(message = "summer, car, backpacking, citytrip, etc.")
    private String category;

    @NotBlank(message = "short description")
    private String description;

    @NotNull
    @Max(value = 750, message = "Travel time must be less than or equal to 750 days")
    private int duration;

    private List<Users> users;

    private List<Favorites> favorites;
}

