package com.graduation.backend.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.graduation.backend.model.Travels;
import com.graduation.backend.model.Users;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FavoritesDto {

        private Long id;

}
