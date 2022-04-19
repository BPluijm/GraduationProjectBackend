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
        List<TravelsDto> travels = new ArrayList<>();

        for (Travels tr : ld) {
            TravelsDto trdto = new TravelsDto(tr.getId(), tr.getStartYear(), tr.getCountry(), tr.getCity(), tr.getTravelType(), tr.getDescription(), tr.getTravelTime());
            travels.add(trdto);
        }

        return travels;
    }

//   @Override
    public Travels createTravels(TravelsDto travelsDto) {
        Travels tr = new Travels();
        tr.setStartYear(travelsDto.getStartYear());
        tr.setCountry(travelsDto.getCountry());
        tr.setCity(travelsDto.getCity());
        tr.setTravelType(travelsDto.getTravelType());
        tr.setDescription(travelsDto.getDescription());
        tr.setTravelTime(travelsDto.getTravelTime());
        return this.repos.save(tr);
    }
}
