package com.graduation.backend.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.graduation.backend.model.Favorites;
import lombok.*;

import javax.validation.constraints.*;
import java.util.List;



@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TravelsDto {
    private Long id;

    @NotBlank
    private String country;

    @NotBlank(message = "enter the year you were there")
    private int years;

    @NotBlank
    private String city;

    @NotBlank(message = "summer, car, backpacking, citytrip, etc.")
    private String category;

    @NotBlank(message = "short description")
    private String description;

    @NotEmpty
    @Max(value = 750, message = "travel time must be less than or equal to 750 days")
    private int duration;

    private List<Favorites> favorites;

}

