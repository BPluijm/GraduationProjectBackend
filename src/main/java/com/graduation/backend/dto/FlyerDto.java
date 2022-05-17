package com.graduation.backend.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.graduation.backend.model.HotSpots;
import com.graduation.backend.model.TravelTips;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FlyerDto {

    private Long id;

    @JsonIgnore
    private byte[] carPapers;

    private TravelTips travelTips;

    private HotSpots hotspots;


}
