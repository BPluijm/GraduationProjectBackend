package com.graduation.backend.service;

import com.graduation.backend.dto.FutureTravelsDto;
import com.graduation.backend.model.FutureTravels;

import java.util.List;

public interface FutureTravelsService {
    List<FutureTravelsDto> getFutureTravels();
    FutureTravels createFutureTravels(FutureTravelsDto futureTravelsDto);
}
