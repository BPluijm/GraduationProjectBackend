package com.graduation.backend.dto;

import lombok.Data;
import javax.validation.constraints.*;

@Data
public class FutureTravelsDto {
    private final Long id;

    @NotBlank
    private final String country;

    @NotBlank
    private final String cities;

    @NotBlank(message = "please select one of the following: ....")
    private final String travelType;

    @NotEmpty
    @Max(value = 365, message = "travel time must be less than or equal to 365 days")
    private final int travelTime;

    @NotEmpty
    private final int expectedCosts;


}
