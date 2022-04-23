package com.graduation.backend.dto;

import lombok.Data;
import javax.validation.constraints.*;


@Data
public class TravelsDto {
    private final Long id;

    @NotBlank
    private final String country;

    @NotBlank(message = "enter the year you were there")
    private final int years;

    @NotBlank
    private final String city;

    @NotBlank(message = "summer, car, backpacking, citytrip, etc.")
    private final String category;

    @NotBlank(message = "short description")
    private final String description;

    @NotEmpty
    @Max(value = 750, message = "travel time must be less than or equal to 750 days")
    private final int duration;
}

