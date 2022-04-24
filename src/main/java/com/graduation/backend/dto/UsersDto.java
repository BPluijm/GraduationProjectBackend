//package com.graduation.backend.dto;
//
//import com.fasterxml.jackson.annotation.*;
//import com.fasterxml.jackson.annotation.JsonInclude.Include;
//import com.graduation.backend.enums.Role;
//import com.graduation.backend.model.Users;
//import lombok.*;
//
//import javax.persistence.Enumerated;
//import javax.validation.constraints.*;
//import java.util.List;
//
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@JsonInclude(Include.NON_NULL)
//public class UsersDto {
//
//    private Long id;
//
//    @NotNull(message = "Username can't be null")
//    @NotBlank(message = "Username must be filled in")
//    private String username;
//
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//    @NotNull(message = "Password can't be null")
//    @NotBlank(message = "Password must be filled in")
//    private String password;
//
//    @NotNull(message = "Firstname can't be null")
//    @NotBlank(message = "Firstname must be filled in")
//    private String firstname;
//
//    @NotNull(message = "Lastname cant be null")
//    @NotBlank(message = "Lastname must be filled in")
//    private String lastname;
//
//    @NotNull(message = "Email can't be null")
//    @NotBlank(message = "Email must be filled in")
//    @Email(message = "Not a valid email address")
//    private String email;
//
//    @NotNull(message = "Street can't be null")
//    @NotBlank(message = "Street must be filled in")
//    private String street;
//
//    @NotNull(message = "House number can't be null")
//    @NotBlank(message = "House number must be filled in")
//    private Integer housenumber;
//
//    @NotNull(message = "Zipcode can't be null")
//    @NotBlank(message = "Zipcode must be filled in")
//    @Pattern(regexp = "^[1-9][0-9]{3} ?[a-z]{2}$" , flags = Pattern.Flag.CASE_INSENSITIVE, message = "Invalid Zipcode") // regex dutch postal / zipcode
//    private String zipcode;
//
//    @NotNull(message = "City can't be null")
//    @NotBlank(message = "City must be filled in")
//    private String city;
//
////    @NotNull(message = "Favorites cant be null")
////    @NotBlank(message = "Favorites cant be blank")
////    private String favorites;
//
//    private Boolean enabled = true;
//
//    @Enumerated
//    private Role role;
//
//    private List<Users> users;
//}
//
