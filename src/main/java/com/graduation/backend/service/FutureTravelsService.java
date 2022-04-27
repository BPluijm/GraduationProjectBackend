package com.graduation.backend.service;

import com.graduation.backend.dto.FutureTravelsDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FutureTravelsService {
    List<FutureTravelsDto> getFutureTravels();
    FutureTravelsDto getFutureTravelsById(Long id);
    FutureTravelsDto createFutureTravels(FutureTravelsDto fut);
    FutureTravelsDto updateFutureTravels(FutureTravelsDto ftdto, Long id);
    FutureTravelsDto deleteFutureTravels(Long id);
    String addTips(Long tipId, MultipartFile tips);
}
