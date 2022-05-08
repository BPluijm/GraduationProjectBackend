package com.graduation.backend.service;

import com.graduation.backend.dto.FavoritesDto;
import com.graduation.backend.model.Favorites;

import java.util.List;

public interface FavoritesService {
    List<FavoritesDto> getFavorites ();
    FavoritesDto getFavoritesById(Long id);
    Favorites createFavorites(FavoritesDto favo);
    String deleteFavorites(Long id);
}
