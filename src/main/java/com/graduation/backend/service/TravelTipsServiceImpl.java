package com.graduation.backend.service;

import com.graduation.backend.dto.TravelTipsDto;
import com.graduation.backend.model.TravelTips;
import com.graduation.backend.repository.TravelTipsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TravelTipsServiceImpl implements TravelTipsService {
    private final TravelTipsRepository repos;

    public TravelTipsServiceImpl(TravelTipsRepository repos) {
        this.repos = repos;
    }

    @Override
    public List<TravelTipsDto> getTravelTips() {
        List<TravelTips> ld = this.repos.findAll();
        List<TravelTipsDto> trips = new ArrayList<>();

        for (TravelTips tt : ld) {
            TravelTipsDto ttdto = new TravelTipsDto(tt.getId(), tt.getName(), tt.getCountry(), tt.getCity(), tt.getDescription());
            trips.add(ttdto);
        }

        return trips;
    }

    @Override
    public TravelTips createTravelTips(TravelTipsDto travelTipsDto) {
        TravelTips tt = new TravelTips();
        tt.setName(travelTipsDto.getName());
        tt.setCountry(travelTipsDto.getCountry());
        tt.setCity(travelTipsDto.getCity());
        tt.setDescription(travelTipsDto.getDescription());
        return this.repos.save(tt);
    }
}
