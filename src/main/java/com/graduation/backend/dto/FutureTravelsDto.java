package com.graduation.backend.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.graduation.backend.model.TravelTips;
import com.graduation.backend.model.Users;
import lombok.*;
import javax.validation.constraints.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FutureTravelsDto {

    private Long id;

    @NotBlank(message = "Please enter a country")
    private String country;

    @NotBlank(message = "Please enter an area in this country")
    private String area;

    @NotBlank(message = "Please enter a travel type like; summer, car, backpacking, citytrip, etc.")
    private String category;

    @NotNull
    @Max(value = 90, message = "Please enter a travel time that is less than or equal to 90 days")
    private int duration;

    @NotNull(message = "Please enter the expected costs")
    private int costs;

    private List<TravelTips> travelTips;

    private List<Users> users;
}
