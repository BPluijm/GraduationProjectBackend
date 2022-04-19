package com.graduation.backend.dto;

import com.graduation.backend.model.Users;
import lombok.*;

import javax.validation.constraints.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersDto {

    private Long id;

    @NotNull(message = "firstname cant be null")
    @NotBlank(message = "firstname cant be blank")
    private String firstname;

    @NotNull(message = "lastname cant be null")
    @NotBlank(message = "lastname cant be blank")
    private String lastname;

    @NotNull(message = "email cant be null")
    @NotBlank(message = "email cant be blank")
    @Email(message = "not a valid emailadres")
    private String email;

    @NotNull(message = "street cant be null")
    @NotBlank(message = "street cant be blank")
    private String street;

    @NotNull
    private Integer houseNumber;

    @NotNull(message = "zipcode cant be null")
    @NotBlank(message = "zipcode cant be blank")
    @Pattern(regexp = "^[1-9][0-9]{3} ?[a-z]{2}$" , flags = Pattern.Flag.CASE_INSENSITIVE, message = "Invalid Zipcode") // regex dutch postal / zipcode
    private String zipcode;

    @NotNull(message = "city cant be null")
    @NotBlank(message = "city cant be blank")
    private String city;

    @NotNull(message = "preferences cant be null")
    @NotBlank(message = "preferences cant be blank")
    private String preferences;

    private List<Users> users;


}
