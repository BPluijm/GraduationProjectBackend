package com.graduation.backend.dto;

import lombok.Data;
import javax.validation.constraints.*;

@Data
public class TravelTipsDto {

        private final Long id;

        @NotBlank
        private final String name;

        @NotBlank
        private final String country;

        @NotBlank
        private final String city;

        @NotBlank
        private final String description;

}
