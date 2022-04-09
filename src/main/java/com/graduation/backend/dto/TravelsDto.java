package com.graduation.backend.dto;

import lombok.Data;
import javax.validation.constraints.*;


@Data
public class TravelsDto {
    private final Long id;

    @NotBlank
    private final String country;

    @NotBlank(message = "please select one of the following: ....")
    private final String travelType;

    @NotEmpty
    @Max(value = 365, message = "travel time must be less than or equal to 365 days")
    private final int travelTime;
}

