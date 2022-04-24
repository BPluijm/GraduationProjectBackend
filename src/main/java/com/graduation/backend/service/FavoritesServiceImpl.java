package com.graduation.backend.service;

import com.graduation.backend.dto.FavoritesDto;
import com.graduation.backend.service.FavoritesService;
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
    public FavoritesDto createFavorites(FavoritesDto favoritesDto) {
        Favorites favo = mapper.map(favoritesDto, Favorites.class);
        Favorites favorite = repos.save(favo);
        return mapper.map(favorite, FavoritesDto.class);
    }


}
