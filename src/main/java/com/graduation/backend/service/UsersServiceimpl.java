package com.graduation.backend.service;


import com.graduation.backend.dto.UsersDto;
import com.graduation.backend.exceptions.RecordNotFoundException;
import com.graduation.backend.model.Users;
import com.graduation.backend.repository.UsersRepository;
import org.jetbrains.annotations.NotNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.validation.Valid;
import java.util.*;


@Service
public class UsersServiceimpl implements UsersService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    FavoritesRepository FavoritesRepository;

    @Override
    public UsersDto createUsers(@Valid UsersDto usersDto) {
        Users newUsers = modelMapper.map(usersDto, Users.class);
        Users savedUsers = usersRepository.save(newUsers);
        return modelMapper.map(savedUsers, UsersDto.class);
    }

    @Override
    public List<UsersDto> findAllUsers() {
        List<Users> us =  usersRepository.findAll();
        List<UsersDto> usersDto = new ArrayList<>();

        for(Users users : us) {
            UsersDto uDto = modelMapper.map(users, UsersDto.class);
            usersDto.add(uDto);
        }
        return usersDto;
    }

    @Override
    public UsersDto findUsersById(Long id) {
        Optional<Users> users =  usersRepository.findById(id);
        if (users.isPresent()){
            UsersDto uDto = modelMapper.map(users.get(), UsersDto.class);
            return uDto;

        } else {
            throw new RecordNotFoundException("User not found");
        }
    }

    @Override
    public List<FavoritesDto> findFavorites(Long id) {
        Optional<Users> users = usersRepository.findById(id);
        List<UsersDto> usersDto = new ArrayList<>();
        if(users.isPresent()) {
            List<Favorites> favorites =  users.get().getUsers();
            for(Users us : users){
                UsersDto usersDto = modelMapper.map(us, UsersDto.class);
                usersDto.add(usersDto);
            }
            return usersDto;
        } else {
            throw new RecordNotFoundException("No favorites found");
        }
    }

    @Override
    public UsersDto updateUsers(@NotNull UsersDto usersDto, Long id) {
        Users users = usersRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("user not found"));
        users.setFirstname(usersDto.getFirstname());
        users.setLastname(usersDto.getLastname());
        users.setStreet(usersDto.getStreet());
        users.setZipcode(usersDto.getZipcode());
        users.setEmail(usersDto.getEmail());
        users.setHouseNumber(usersDto.getHouseNumber());
        users.setCity(usersDto.getCity());
        users.setFavorites(usersDto.getFavorites());
        usersRepository.save(users);
        return modelMapper.map(users, UsersDto.class);
    }

    @Override
    public UsersDto deleteUsers(Long id) {
        Optional<Users> users = usersRepository.findById(id);
        if(users.isPresent()){
            if(users.get().getFavorites() != null){
                for (Favorites favorites : users.get().getFavorites()){
                    Long usersId = users.getId();
                    usersRepository.deleteById(usersId);
                }
            }
            UsersDto usersDto = modelMapper.map(users.get(), UsersDto.class);
            usersRepository.deleteById(id);
            return usersDto;
        } else {
            throw new RecordNotFoundException("unable to find customer");
        }

    }
}