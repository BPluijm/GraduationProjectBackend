package com.graduation.backend.service;

import com.graduation.backend.dto.UsersDto;
import com.graduation.backend.exceptions.RecordNotFoundException;
import com.graduation.backend.model.Users;
import com.graduation.backend.repository.UsersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

//import org.jetbrains.annotations.NotNull;
//import javax.validation.Valid;


@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    UsersRepository repos;

    @Autowired
    private PasswordEncoder encoder;

//    @Autowired
//    FavoritesRepository FavoritesRepository;

    @Override
    public UsersDto createUsers(UsersDto udto) {
        udto.setPassword(encoder.encode(udto.getPassword()));
        Users newUsers = mapper.map(udto, Users.class);
        Users savedUsers = repos.save(newUsers);
        return mapper.map(savedUsers, UsersDto.class);
    }

    @Override
    public List<UsersDto> findAllUsers() {
        List<Users> us =  repos.findAll();
        List<UsersDto> usersDto = new ArrayList<>();

        for(Users users : us) {
            UsersDto udto = mapper.map(users, UsersDto.class);
            usersDto.add(udto);
        }
        return usersDto;
    }

    @Override
    public UsersDto findByUserId(Long id) {
        Optional<Users> users =  repos.findById(id);
        if (users.isPresent()){
            UsersDto uDto = mapper.map(users.get(), UsersDto.class);
            return uDto;
        } else {
            throw new RecordNotFoundException("User not found");
        }
    }

    ////    @Override
////    public List<FavoritesDto> findFavorites(Long id) {
////        Optional<Users> users = usersRepository.findById(id);
////        List<UsersDto> usersDto = new ArrayList<>();
////        if(users.isPresent()) {
////            List<Favorites> favorites =  users.get().getUsers();
////            for(Users us : users){
////                UsersDto usersDto = modelMapper.map(us, UsersDto.class);
////                usersDto.add(usersDto);
////            }
////            return usersDto;
////        } else {
////            throw new RecordNotFoundException("No favorites found");
////        }
////    }
//


    @Override
    public UsersDto updateUsers(UsersDto usersDto, Long id) {
        Users users = repos.findById(id).orElseThrow(() -> new RecordNotFoundException("User not in our system"));
        users.setUsername(usersDto.getUsername());
        users.setPassword(encoder.encode(usersDto.getPassword()));
        users.setFirstname(usersDto.getFirstname());
        users.setLastname(usersDto.getLastname());
        users.setEmail(usersDto.getEmail());
        users.setStreet(usersDto.getStreet());
        users.setHousenumber(usersDto.getHousenumber());
        users.setZipcode(usersDto.getZipcode());
        users.setCity(usersDto.getCity());
//        users.setFavorites(usersDto.getFavorites());
        users.setEnabled(usersDto.getEnabled());
        users.setRole(usersDto.getRole().toString());
        repos.save(users);
        return mapper.map(users, UsersDto.class);
    }

    @Override
    public UsersDto deleteUsers(Long id) {
        Optional<Users> users = repos.findById(id);
        if(users.isPresent()){
////            if(users.get().getFavorites() != null){
////                for (Favorites favorites : users.get().getFavorites()){
////                    Long usersId = users.getId();
////                    usersRepository.deleteById(usersId);
////                }
////            }
            UsersDto usersDto = mapper.map(users.get(), UsersDto.class);
            repos.deleteById(id);
            return usersDto;
        } else {
            throw new RecordNotFoundException("Unable to find user");
        }
    }
}
