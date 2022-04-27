package com.graduation.backend.service;

import com.graduation.backend.dto.FutureTravelsDto;
import com.graduation.backend.model.FutureTravels;

import java.util.List;

public interface FutureTravelsService {
    List<FutureTravelsDto> getFutureTravels();
    FutureTravelsDto getFutureTravelsById(Long id);
    FutureTravelsDto createFutureTravels(FutureTravelsDto fut);
    FutureTravelsDto updateFutureTravels(FutureTravelsDto ftdto, Long id);
    FutureTravelsDto deleteFutureTravels(Long id);
}
