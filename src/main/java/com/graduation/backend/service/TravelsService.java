package com.graduation.backend.service;

import com.graduation.backend.dto.TravelsDto;
import com.graduation.backend.model.Travels;

import java.util.List;

public interface TravelsService {
    List<TravelsDto> getTravels();
    Travels createTravels(TravelsDto travelsDto);
//    List<TravelsDto> getTravelsById(Long id);

//    TravelsDto getByTravelsId(Long id);
////    List<TravelsDto> getTravels();
//    TravelsDto updateTravels(TravelsDto travelsDto, Long id);
//    TravelsDto deleteTravels(Long id);
}


