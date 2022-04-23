package com.graduation.backend.dto;

import lombok.Data;
import javax.validation.constraints.*;

@Data
public class FutureTravelsDto {
    private final Long id;

    @NotBlank(message = "please enter a country")
    private final String country;

    @NotBlank(message = "enter an area in this country")
    private final String area;

    @NotBlank(message = "summer, car, backpacking, citytrip, etc.")
    private final String travelType;

    @NotEmpty
    @Max(value = 90, message = "travel time must be less than or equal to 90 days")
    private final int travelTime;

    @NotEmpty(message = "enter the expected costs")
    private final int expectedCosts;


}
