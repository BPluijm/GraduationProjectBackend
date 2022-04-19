package com.graduation.backend.service;

import com.graduation.backend.dto.UsersDto;

import java.util.List;

public interface UsersService {
    UsersDto createUsers(UsersDto usersDto);
    List<UsersDto> findAllUsers();
    UsersDto findUsersById (Long id);
    List<UsersDto> findUsersTravels (Long id);
    UsersDto updateUsers (UsersDto usersDto, Long id);
    UsersDto deleteUsers(Long id);
}
