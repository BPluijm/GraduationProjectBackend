package com.graduation.backend.service;

import com.graduation.backend.dto.UsersDto;

import java.util.List;

public interface UsersService {
    List<UsersDto> getUsers();
    UsersDto createUsers(UsersDto usersDto);
    UsersDto findByUserId(Long id);
    UsersDto updateUsers(UsersDto userDto, Long id);
    UsersDto deleteUsers(Long id);
}

//    List<TravelTipsDto> getTravelTips();
//    TravelTips createTravelTips(TravelTipsDto travelTipsDto);