package com.graduation.backend.service;

import com.graduation.backend.dto.TravelsDto;
import com.graduation.backend.exceptions.RecordNotFoundException;
import com.graduation.backend.model.Travels;
import com.graduation.backend.model.Users;
import com.graduation.backend.repository.TravelsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class TravelsServiceImpl implements TravelsService {

    private final ModelMapper mapper = new ModelMapper();

    @Autowired
    TravelsRepository repos;

    @Override
    public List<TravelsDto> getTravels() {
        List<Travels> ld = this.repos.findAll();
        List<TravelsDto> travels = new ArrayList<>();
        for (Travels tr : ld) {
            TravelsDto trdto = mapper.map(tr, TravelsDto.class);
            travels.add(trdto);
        }
        return travels;
    }

    @Override
    public TravelsDto getTravelsById(Long id) {
        Optional<Travels> t = repos.findById(id);
        if (t.isPresent()) {
            Travels trvl = t.get();
            return mapper.map(trvl, TravelsDto.class);
        } else {
            throw new RecordNotFoundException("Trip not found");
        }
    }

    @Override
    public Travels createTravels(TravelsDto trip) {
        Travels t = new Travels();
        t.setCountry(trip.getCountry());
        t.setYears(trip.getYears());
        t.setCity(trip.getCity());
        t.setCategory(trip.getCategory());
        t.setDescription(trip.getDescription());
        t.setDuration(trip.getDuration());
        return this.repos.save(t);
    }

    @Override
    public TravelsDto updateTravels(TravelsDto tvl, Long id) {
        Travels tl = repos.findById(id).orElseThrow(() -> new RecordNotFoundException("Trip not found"));
        tl.setCountry(tvl.getCountry());
        tl.setYears(tvl.getYears());
        tl.setCity(tvl.getCity());
        tl.setCategory(tvl.getCategory());
        tl.setDescription(tvl.getDescription());
        tl.setFavorites(tvl.getFavorites());
        tl.setUsers((Users) tvl.getUsers());
        repos.save(tl);
        return mapper.map(tl, TravelsDto.class);
    }

    @Override
    public TravelsDto deleteTravels(Long id) {
        Optional<Travels> tra = repos.findById(id);
        if(tra.isPresent()){
            TravelsDto trav = mapper.map(tra.get(), TravelsDto.class);
            repos.deleteById(id);
            return trav;
        } else {
            throw new RecordNotFoundException("Unable to delete trip");
        }
    }
}
