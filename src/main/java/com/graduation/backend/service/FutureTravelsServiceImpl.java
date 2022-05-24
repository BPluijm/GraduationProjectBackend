package com.graduation.backend.service;

import com.graduation.backend.dto.FutureTravelsDto;
import com.graduation.backend.exceptions.RecordNotFoundException;
import com.graduation.backend.model.FutureTravels;
import com.graduation.backend.repository.FutureTravelsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class FutureTravelsServiceImpl implements FutureTravelsService {

    private final ModelMapper mapper = new ModelMapper();

    @Autowired
    FutureTravelsRepository repos;

    @Override
    public List<FutureTravelsDto> getFutureTravels() {
        List<FutureTravels> ld = repos.findAll();
        List<FutureTravelsDto> fut = new ArrayList<>();
        for (FutureTravels ft : ld) {
            FutureTravelsDto ftdto = mapper.map(ft, FutureTravelsDto.class);
            fut.add(ftdto);
        }
        return fut;
    }

    @Override
    public FutureTravelsDto getFutureTravelsById(Long id) {
        Optional<FutureTravels> fts = repos.findById(id);
        if (fts.isPresent()) {
            FutureTravels futs = fts.get();
            return mapper.map(futs, FutureTravelsDto.class);
        } else {
            throw new RecordNotFoundException("Future trip not found");
        }
    }

    @Override
    public FutureTravels createFutureTravels(FutureTravelsDto fut) {
        FutureTravels ft = new FutureTravels();
        ft.setCountry(fut.getCountry());
        ft.setArea(fut.getArea());
        ft.setCategory(fut.getCategory());
        ft.setCategory(fut.getCategory());
        ft.setDuration(fut.getDuration());
        ft.setCosts(fut.getCosts());
        return this.repos.save(ft);
    }

    @Override
    public FutureTravelsDto updateFutureTravels(FutureTravelsDto ftd, Long id) {
        FutureTravels ft = repos.findById(id).orElseThrow(() -> new RecordNotFoundException("Future trip not found"));
        ft.setCountry(ftd.getCountry());
        ft.setArea(ftd.getArea());
        ft.setCategory(ftd.getCategory());
        ft.setDuration(ftd.getDuration());
        ft.setCosts(ftd.getCosts());
//        ft.setTips(ftd.getTips());
//        ft.getUsers(ftd.getUsers());
        repos.save(ft);
        return mapper.map(ft, FutureTravelsDto.class);
    }


    @Override
    public FutureTravelsDto deleteFutureTravels(Long id) {
        Optional<FutureTravels> ftr = repos.findById(id);
        if(ftr.isPresent()){
            FutureTravelsDto futured = mapper.map(ftr.get(), FutureTravelsDto.class);
            repos.deleteById(id);
            return futured;
        } else {
            throw new RecordNotFoundException("Unable to find future trip");
        }
    }
}
