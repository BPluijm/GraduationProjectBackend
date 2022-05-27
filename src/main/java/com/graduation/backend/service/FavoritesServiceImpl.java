package com.graduation.backend.service;

import com.graduation.backend.dto.FavoritesDto;
import com.graduation.backend.exceptions.RecordNotFoundException;
import com.graduation.backend.model.Favorites;
import com.graduation.backend.model.Travels;
import com.graduation.backend.model.Users;
import com.graduation.backend.repository.FavoritesRepository;
import com.graduation.backend.repository.TravelsRepository;
import com.graduation.backend.repository.UsersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class FavoritesServiceImpl implements FavoritesService {

    private final ModelMapper mapper = new ModelMapper();

    @Autowired
    FavoritesRepository repos;

    @Autowired
    TravelsRepository tRepo;

    @Autowired
    UsersRepository uRepo;

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
            throw new RecordNotFoundException("Favorites not found");
        }
    }

    @Override
    public Favorites createFavorites(FavoritesDto favo) {
        Favorites f = new Favorites();

        Travels t = tRepo.getById(favo.getTravels_id());
        Users u = uRepo.getById(favo.getUsers_id());
        f.setTravels(t);
        f.setUsers(u);

        return this.repos.save(f);
    }

    @Override
    public FavoritesDto deleteFavorites(Long id) {
        Optional<Favorites> favorites = repos.findById(id);
        if(favorites.isPresent()){
            FavoritesDto favoritesDto = mapper.map(favorites.get(), FavoritesDto.class);
            repos.deleteById(id);
            return favoritesDto;
        } else {
            throw new RecordNotFoundException("Unable to delete favorite");
        }
    }
}
