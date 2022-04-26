package com.graduation.backend.service;

import com.graduation.backend.dto.FavoritesDto;
import java.util.List;

public interface FavoritesService {
    FavoritesDto createFavorites(FavoritesDto favoritesDto);
    List<FavoritesDto> getFavorites ();
    FavoritesDto getFavoritesById(Long id);
    String deleteFavorites(Long id);
}
