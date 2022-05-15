package com.graduation.backend.service;

import com.graduation.backend.dto.TravelsDto;
import com.graduation.backend.model.Travels;

import java.util.List;

public interface TravelsService {
    List<TravelsDto> getTravels();
    TravelsDto getTravelsById(Long id);
    Travels createTravels(TravelsDto travelsDto);
    TravelsDto updateTravels(TravelsDto tdto, Long id);
    TravelsDto deleteTravels(Long id);
//    String addFavorites(Long id);
}


