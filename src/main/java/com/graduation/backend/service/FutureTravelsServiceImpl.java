package com.graduation.backend.service;

import com.graduation.backend.dto.FutureTravelsDto;
import com.graduation.backend.model.FutureTravels;
import com.graduation.backend.repository.FutureTravelsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FutureTravelsServiceImpl implements FutureTravelsService {

    private final FutureTravelsRepository repos;

    public FutureTravelsServiceImpl(FutureTravelsRepository repos) {
        this.repos = repos;
    }

    @Override
    public List<FutureTravelsDto> getFutureTravels() {
        List<FutureTravels> ld = this.repos.findAll();
        List<FutureTravelsDto> futureTravels = new ArrayList<>();

        for (FutureTravels ft : ld) {
            FutureTravelsDto ftdto = new FutureTravelsDto(ft.getId(), ft.getCountry(), ft.getArea(), ft.getTravelType(), ft.getTravelTime(), ft.getExpectedCosts());
            futureTravels.add(ftdto);
        }

        return futureTravels;
    }

    @Override
    public FutureTravels createFutureTravels(FutureTravelsDto futureTravelsDto) {
        FutureTravels ft = new FutureTravels();
        ft.setCountry(futureTravelsDto.getCountry());
        ft.setArea(futureTravelsDto.getArea());
        ft.setTravelType(futureTravelsDto.getTravelType());
        ft.setTravelTime(futureTravelsDto.getTravelTime());
        ft.setExpectedCosts(futureTravelsDto.getExpectedCosts());
        return this.repos.save(ft);
    }
}
