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
            FutureTravelsDto ftdto = new FutureTravelsDto(ft.getId(), ft.getCountry(), ft.getArea(), ft.getCategory(), ft.getDuration(), ft.getCosts());
            futureTravels.add(ftdto);
        }

        return futureTravels;
    }

    @Override
    public FutureTravels createFutureTravels(FutureTravelsDto fut) {
        FutureTravels ft = new FutureTravels();
        ft.setCountry(fut.getCountry());
        ft.setArea(fut.getArea());
        ft.setCategory(fut.getCategory());
        ft.setDuration(fut.getDuration());
        ft.setCosts(fut.getCosts());
        return this.repos.save(ft);
    }
}
