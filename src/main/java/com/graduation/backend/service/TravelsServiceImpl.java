package com.graduation.backend.service;

import com.graduation.backend.dto.TravelsDto;
import com.graduation.backend.exceptions.RecordNotFoundException;
import com.graduation.backend.model.Favorites;
import com.graduation.backend.model.Travels;
import com.graduation.backend.repository.TravelsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;


@Service
public class TravelsServiceImpl implements TravelsService {

    @Autowired
    TravelsRepository repos;

    @Autowired
    FavoritesService = service;

    @Autowired
    private ModelMapper mapper;

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
    public TravelsDto createTravels(TravelsDto trip) {
        Travels tr = mapper.map(trip, Travels.class);
        Travels trav = repos.save(tr);
        return mapper.map(trav, TravelsDto.class);
    }

    @Override
    public String addFavorites(Long travelsId, MultipartFile favorites) throws IOException {
        Travels travels = repos.findById(travelsId).get();
        Favorites favorite =  service.createFavorites(favorites);
        favorites.setTravels(travels);
        travels.setFavorites(favorite);
        repos.save(travels);
        return "Added to your favorites";
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
        repos.save(tl);
        return mapper.map(tl, TravelsDto.class);
    }

    @Override
    public TravelsDto deleteTravels(Long id) {
        Optional<Travels> tra = repos.findById(id);
        if(tra.isPresent()){
            TravelsDto trav = mapper.map(tra.get(), TravelsDto.class);
            TravelsDto.deleteById(id);
            return trav;
        } else {
            throw new RecordNotFoundException("Unable to find trip");
        }
    }

}
