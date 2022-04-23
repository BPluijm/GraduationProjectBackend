package com.graduation.backend.service;

import com.graduation.backend.dto.TravelsDto;
import com.graduation.backend.model.Travels;

import java.util.List;

public interface TravelsService {
    List<TravelsDto> getTravels();
    Travels createTravels(TravelsDto travelsDto);
//    TravelsDto findTravelById(Long id);
//    TravelsDto updateTravel(TravelsDto travelsDto, Long id);
//    TravelsDto deleteTravel(Long id);


//    FavoriteDto findCarByLicensePlate (String licensePlate);
//
//    String addCarPapersToCar(Long carId, MultipartFile carPapers) throws IOException;

}


