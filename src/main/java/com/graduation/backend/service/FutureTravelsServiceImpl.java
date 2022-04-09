package com.graduation.backend.service;

import com.graduation.backend.dto.FutureTravelsDto;
import com.graduation.backend.model.FutureTravels;
import com.graduation.backend.repository.FutureTravelsRepository;

import java.util.ArrayList;
import java.util.List;

public class FutureTravelsServiceImpl implements FutureTravelsService {

    private final FutureTravelsRepository repos;

    public FutureTravelsServiceImpl(FutureTravelsRepository repos) {
        this.repos = repos;
    }

    @Override
    public List<FutureTravelsDto> getFutureTravels() {
        List<FutureTravels> ld = this.repos.findAll();
        List<FutureTravelsDto> trips = new ArrayList<>();

        for (FutureTravels ft : ld) {
            FutureTravelsDto ftdto = new FutureTravelsDto(ft.getId(), ft.getCountry(), ft.getCities(), ft.getTravelType(), ft.getTravelTime(), ft.getExpectedCosts());
            FutureTravels.add(ftdto);
        }

        return trips;
    }

    @Override
    public FutureTravels createFutureTravels(FutureTravelsDto futureTravelsDto) {
        FutureTravels ft = new FutureTravels();
        ft.setCountry(futureTravelsDto.getCountry());
        ft.setCities(futureTravelsDto.getCities());
        ft.setTravelType(futureTravelsDto.getTravelType());
        ft.setTravelTime(futureTravelsDto.getTravelTime());
        ft.setExpectedCosts(futureTravelsDto.getExpectedCosts());
        return this.repos.save(ft);
    }
}
