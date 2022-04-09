package com.graduation.backend.service;

import com.graduation.backend.dto.TravelsDto;
import com.graduation.backend.model.Travels;
import com.graduation.backend.repository.TravelsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TravelsServiceImpl {

    private final TravelsRepository repos;

    public TravelsServiceImpl(TravelsRepository repos) {
        this.repos = repos;
    }

//    @Override
    public List<TravelsDto> getTravels() {
        List<Travels> ld = this.repos.findAll();
        List<TravelsDto> trips = new ArrayList<>();

        for (Travels tr : ld) {
            TravelsDto trdto = new TravelsDto(tr.getId(), tr.getCountry(), tr.getTravelType(), tr.getTravelTime());
            trips.add(trdto);
        }

        return trips;
    }

//   @Override
    public Travels createTravels(TravelsDto travelsDto) {
        Travels tr = new Travels();
        tr.setCountry(travelsDto.getCountry());
        tr.setTravelType(travelsDto.getTravelType());
        tr.setTravelTime(travelsDto.getTravelTime());
        return this.repos.save(tr);
    }
}
