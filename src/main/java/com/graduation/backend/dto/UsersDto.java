package com.graduation.backend.dto;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.graduation.backend.enums.Role;
import com.graduation.backend.model.Favorites;
import com.graduation.backend.model.TravelTips;
import lombok.*;

import javax.persistence.Enumerated;
import javax.validation.constraints.*;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class UsersDto {

    private Long id;

    @NotNull(message = "Username can't be null")
    @NotBlank(message = "Username must be filled in")
    private String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotBlank(message = "Password must be filled in")
    private String password;

    @NotBlank(message = "Firstname must be filled in")
    private String firstname;

    @NotBlank(message = "Lastname must be filled in")
    private String lastname;

    @NotBlank(message = "Email must be filled in")
    @Email(message = "Not a valid email address")
    private String email;

    @NotBlank(message = "Street must be filled in")
    private String street;

    @NotNull(message = "House number can't be null")
    private Integer housenumber;

    @NotNull(message = "Zipcode can't be null")
    @NotBlank(message = "Zipcode must be filled in")
    @Pattern(regexp = "^[1-9][0-9]{3} ?[a-z]{2}$" , flags = Pattern.Flag.CASE_INSENSITIVE, message = "Invalid Zipcode") // regex dutch postal / zipcode
    private String zipcode;

    @NotBlank(message = "City must be filled in")
    private String city;

    private Boolean enabled = true;

    @Enumerated
    private Role role;

    private List<Favorites> favorites;

//    private List<TravelTips> travelTips;

}

