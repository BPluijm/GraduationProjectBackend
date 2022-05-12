package com.graduation.backend.service;

import com.graduation.backend.dto.FavoritesDto;
import com.graduation.backend.exceptions.RecordNotFoundException;
import com.graduation.backend.model.Favorites;
import com.graduation.backend.repository.FavoritesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class FavoritesServiceImpl implements FavoritesService {


    @Autowired
    FavoritesRepository repos;

    @Autowired
    private ModelMapper mapper;

        @Override
    public List<FavoritesDto> getFavorites() {
        List<Favorites> fav = repos.findAll();
        List<FavoritesDto> fdto = new ArrayList<>();
        for (Favorites favo : fav) {
            FavoritesDto favoDto= mapper.map(favo, FavoritesDto.class);
            fdto.add(favoDto);
        }
        return fdto;
    }

    @Override
    public FavoritesDto getFavoritesById(Long id) {
        Optional<Favorites> f = repos.findById(id);
        if (f.isPresent()) {
            Favorites ft = f.get();
            return mapper.map(ft, FavoritesDto.class);
        } else {
            throw new RecordNotFoundException("Trip not found");
        }
    }

    @Override
    public Favorites createFavorites(FavoritesDto favo) {
        Favorites f = new Favorites();
        f.setId(favo.getId());

//        f.setTravels(favo.getTravels());
//        f.setUsers(favo.getUsers());

        return this.repos.save(f);
    }


    @Override
    public String deleteFavorites(Long id) {
        Favorites favorite = repos.findById(id).orElseThrow(() -> new RecordNotFoundException("Favorite not found"));
        repos.deleteById(id);
        return "Favorite deleted";

    }

}
