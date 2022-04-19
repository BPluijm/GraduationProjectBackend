package com.graduation.backend.dto;

import lombok.Data;
import javax.validation.constraints.*;


@Data
public class TravelsDto {
    private final Long id;

    @NotBlank
    private final String country;

    @NotBlank
    private final String city;

    @NotBlank(message = "summer, car, backpacking, citytrip, etc.")
    private final String travelType;

    @NotBlank(message = "short description")
    private final String description;

    @NotEmpty
    @Max(value = 365, message = "travel time must be less than or equal to 365 days")
    private final int travelTime;
}

