//package com.graduation.backend.service;
//
//import org.modelmapper.ModelMapper;
//import com.graduation.backend.dto.UsersDto;
//import com.graduation.backend.exceptions.RecordNotFoundException;
//import com.graduation.backend.model.Users;
//import com.graduation.backend.repository.UsersRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.*;
//
//
//@Service
//public class UsersServiceImpl implements UsersService {
//
//    private final UsersRepository repos;
//
//    public UsersServiceImpl(UsersRepository repos) {
//        this.repos = repos;
//    }
//
//    @Autowired
//    private ModelMapper modelMapper;
//
//    @Autowired
//    private PasswordEncoder encoder;
////
//////        @Autowired
//////    FavoritesRepository favo;
//
//
//        @Override
//        public UsersDto createUsers(UsersDto usersDto) {
//            usersDto.setPassword(encoder.encode(usersDto.getPassword()));
//            Users newUser = modelMapper.map(usersDto, Users.class);
//            Users savedUsers = repos.save(newUser);
//            return modelMapper.map(savedUsers, UsersDto.class);
//        }
//
//        @Override
//        public UsersDto findByUserId(Long id) {
//            Optional<Users> users =  repos.findById(id);
//            if (users.isPresent()){
//                UsersDto usersDto = modelMapper.map(users.get(), UsersDto.class);
//                return usersDto;
//            } else {
//                throw new RecordNotFoundException("user not found");
//            }
//        }
//
////        @Override
//        public List<UsersDto> findAllUsers() {
//            List<Users> users =  repos.findAll();
//            List<UsersDto> usersDto = new ArrayList<>();
//
//            for(Users us : users) {
//                UsersDto user = modelMapper.map(us, UsersDto.class);
//                usersDto.add(user);
//            }
//            return usersDto;
//        }
//
//        @Override
//        public UsersDto updateUsers(UsersDto usersDto, Long id) {
//            Users use = repos.findById(id).orElseThrow(() -> new RecordNotFoundException("user not found"));
//            use.setUsername(usersDto.getUsername());
//            use.setPassword(encoder.encode(usersDto.getPassword()));
//            use.setFirstname(usersDto.getFirstname());
//            use.setLastname(usersDto.getLastname());
//            use.setEmail(usersDto.getEmail());
//            use.setStreet(usersDto.getStreet());
//            use.setHousenumber(usersDto.getHousenumber());
//            use.setZipcode(usersDto.getZipcode());
//            use.setCity(usersDto.getCity());
////        users.setFavorites(usersDto.getFavorites());
//            use.setEnabled(usersDto.getEnabled());
//            use.setRole(usersDto.getRole().toString());
//            repos.save(use);
//            return modelMapper.map(use, UsersDto.class);
//        }
//
//        @Override
//        public UsersDto deleteUsers(Long id) {
//            Optional<Users> user = repos.findById(id);
//            if(user.isPresent()){
//                UsersDto userDto = modelMapper.map(user.get(), UsersDto.class);
//                repos.deleteById(id);
//                return userDto;
//            } else {
//                throw new RecordNotFoundException("unable to find user");
//            }
//        }
//    }
//
//
//
//
//
//
////        users.setEnabled(usersDto.getEnabled());
////        users.setRole(usersDto.getRole().toString());
////        repos.save(users);
////        return modelMapper.map(users, UsersDto.class);
//
//
//
//
//
//
////    @Override
////    public List<UsersDto> getUsers() {
////        List<Users> us = this.repos.findAll();
////        List<UsersDto> user = new ArrayList<>();
////
////        for (Users ur : us) {
////            UsersDto udto = new UsersDto(ur.getId(), ur.getUsername(), ur.getPassword(), ur.getFirstname(), ur.getLastname(), ur.getEmail(), ur.getStreet(), ur.getHousenumber(), ur.getZipcode(), ur.getCity(), ur.getEnabled(), ur.getRole());
////            user.add(udto);
////        }
////
////        return user;
////    }
//
////    @Override
////    public Users createUsers(UsersDto dto) {
////        Users us = new Users();
////        us.setUsername(dto.getUsername());
////        dto.setPassword(encoder.encode(dto.getPassword()));
//////        us.setPassword(dto.getPassword());
////        us.setFirstname(dto.getFirstname());
////        us.setLastname(dto.getLastname());
////        us.setEmail(dto.getEmail());
////        us.setStreet(dto.getStreet());
////        us.setHousenumber(dto.getHousenumber());
////        us.setZipcode(dto.getZipcode());
////        us.setCity(dto.getCity());
////        return this.repos.save(us);
////    }
//
//
////    @Override
////    public UsersDto createUsers(UsersDto udto) {
////        udto.setPassword(encoder.encode(udto.getPassword()));
////        Users newUsers = modelMapper.map(udto, Users.class);
////        Users savedUsers = repos.save(newUsers);
////        return modelMapper.map(savedUsers, UsersDto.class);
////    }
//
////    @Override
////    public List<UsersDto> getUsers() {
////        List<Users> us =  repos.findAll();
////        List<UsersDto> usersDto = new ArrayList<>();
////
////        for(Users users : us) {
////            UsersDto udto = modelMapper.map(users, UsersDto.class);
////            usersDto.add(udto);
////        }
////        return usersDto;
////    }
//
////    @Override
////    public UsersDto findByUserId(Long id) {
////        Optional<Users> users =  repos.findById(id);
////        if (users.isPresent()){
////            UsersDto uDtos = modelMapper.map(users.get(), UsersDto.class);
////            return uDtos;
////        } else {
////            throw new RecordNotFoundException("User not found");
////        }
////    }
//
////        @Override
////    public List<FavoritesDto> findFavorites(Long id) {
////        Optional<Users> users = repos.findById(id);
////        List<UsersDto> usersDto = new ArrayList<>();
////        if(users.isPresent()) {
////            List<Favorites> favorites =  users.get().getUsers();
////            for(Users us : users){
////                UsersDto usersDto = mapper.map(us, UsersDto.class);
////                usersDto.add(usersDto);
////            }
////            return usersDto;
////        } else {
////            throw new RecordNotFoundException("No favorites found");
////        }
////    }
////
////
////
////    @Override
////    public UsersDto updateUsers(UsersDto usersDto, Long id) {
////        Users users = repos.findById(id).orElseThrow(() -> new RecordNotFoundException("User unknown in our system"));
////        users.setUsername(usersDto.getUsername());
////        users.setPassword(encoder.encode(usersDto.getPassword()));
////        users.setFirstname(usersDto.getFirstname());
////        users.setLastname(usersDto.getLastname());
////        users.setEmail(usersDto.getEmail());
////        users.setStreet(usersDto.getStreet());
////        users.setHousenumber(usersDto.getHousenumber());
////        users.setZipcode(usersDto.getZipcode());
////        users.setCity(usersDto.getCity());
//////        users.setFavorites(usersDto.getFavorites());
////        users.setEnabled(usersDto.getEnabled());
////        users.setRole(usersDto.getRole().toString());
////        repos.save(users);
////        return modelMapper.map(users, UsersDto.class);
////    }
////
////    @Override
////    public UsersDto deleteUsers(Long id) {
////        Optional<Users> users = repos.findById(id);
////        if(users.isPresent()){
//////            if(users.get().getFavorites() != null){
//////                for (Favorites favorites : users.get().getFavorites()){
//////                    Long usersId = users.getId();
//////                    favo.deleteById(usersId);
//////                }
//////            }
////            UsersDto usersDto = modelMapper.map(users.get(), UsersDto.class);
////            repos.deleteById(id);
////            return usersDto;
////        } else {
////            throw new RecordNotFoundException("Unable to find user");
////        }
////    }
////}
