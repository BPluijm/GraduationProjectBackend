package com.graduation.backend.service;

import com.graduation.backend.dto.FavoritesDto;
import com.graduation.backend.dto.UsersDto;
import com.graduation.backend.model.Users;

import java.util.List;

public interface UsersService {
    List<UsersDto> getUsers();
    UsersDto getUsersById(Long id);
    Users createUsers(UsersDto usersDto);

//    List<FavoritesDto> getUsersFavorites(Long id);

    UsersDto updateUsers(UsersDto userDto, Long id);
    UsersDto deleteUsers(Long id);
}