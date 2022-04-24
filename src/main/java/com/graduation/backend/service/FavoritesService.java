package com.graduation.backend.service;

import com.graduation.backend.dto.FavoritesDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FavoritesService {
    FavoritesDto createFavorites(FavoritesDto favoritesDto);
    List<FavoritesDto> getFavorites ();
}
