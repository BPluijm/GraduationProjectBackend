package com.graduation.backend.service;

import com.graduation.backend.dto.TravelsDto;

import java.util.List;

public interface TravelsService {
    List<TravelsDto> getTravels();
    TravelsDto getTravelsById(Long id);
    TravelsDto createTravels(TravelsDto travelsDto);
//    String addFavorites(Long id);
    TravelsDto updateTravels(TravelsDto tdto, Long id);
    TravelsDto deleteTravels(Long id);
}


