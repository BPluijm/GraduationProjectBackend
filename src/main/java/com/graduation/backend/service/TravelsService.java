package com.graduation.backend.service;

import com.graduation.backend.dto.TravelsDto;

import java.io.IOException;
import java.util.List;

public interface TravelsService {
    List<TravelsDto> getTravels();
    TravelsDto createTravels(TravelsDto travelsDto);
    TravelsDto getTravelsById(Long id);
    String addFavorites(Long travelsId) throws IOException;
    TravelsDto updateTravels(TravelsDto tdto, Long id);
    TravelsDto deleteTravels(Long id);
}


