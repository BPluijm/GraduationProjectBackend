package com.graduation.backend.service;

import com.graduation.backend.dto.TravelsDto;

import java.util.List;

public interface TravelsService {
    List<TravelsDto> getTravels();
    TravelsDto createTravels(TravelsDto travelsDto);
    TravelsDto getTravelsById(Long id);
    String addFavorites(Long travelsId);
    TravelsDto updateTravels(TravelsDto tdto, Long id);
    TravelsDto deleteTravels(Long id);
}


