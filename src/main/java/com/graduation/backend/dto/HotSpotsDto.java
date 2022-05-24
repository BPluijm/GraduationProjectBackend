package com.graduation.backend.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.graduation.backend.model.Flyer;
import com.graduation.backend.model.Users;
import lombok.*;
import javax.validation.constraints.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class HotSpotsDto {
    private Long id;

    @NotBlank(message = "Please enter a suitable name")
    private String name;

    @NotBlank(message = "Please enter a country")
    private String country;

    @NotBlank(message = "Please enter an area in this country")
    private String area;

    private String remark;


    @JsonIgnore
    private Users users;
    private Long users_id;

    @JsonIgnore
    private Flyer flyer;
    private Long flyer_id;

}
