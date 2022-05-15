package com.graduation.backend.service;

import org.modelmapper.ModelMapper;
import com.graduation.backend.dto.UsersDto;
import com.graduation.backend.exceptions.RecordNotFoundException;
import com.graduation.backend.model.Users;
import com.graduation.backend.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.*;


@Service
public class UsersServiceImpl implements UsersService {

    private final UsersRepository repos;

    public UsersServiceImpl(UsersRepository repos) {
        this.repos = repos;
    }

    @Autowired
    private ModelMapper mapper;

//    @Autowired
//    private PasswordEncoder encoder;
//
//        @Autowired
//    FavoritesRepository repos;

    @Override
    public List<UsersDto> getUsers() {
        List<Users> users =  repos.findAll();
        List<UsersDto> usersd = new ArrayList<>();

        for(Users us : users) {
            UsersDto user = mapper.map(us, UsersDto.class);
            usersd.add(user);
        }
        return usersd;
    }

    @Override
    public UsersDto getUsersById(Long id) {
        Optional<Users> users = repos.findById(id);
        if (users.isPresent()) {
            Users use = users.get();
            return mapper.map(use, UsersDto.class);
        } else {
            throw new RecordNotFoundException("User not found");
        }
    }


    @Override
    public Users createUsers(UsersDto userDto) {
        Users u = new Users();
        u.setUsername(userDto.getUsername());
        u.setPassword(userDto.getPassword());
//        u.setPassword(encoder.encode(usersDto.getPassword()));
        u.setFirstname(userDto.getFirstname());
        u.setLastname(userDto.getLastname());
        u.setEmail(userDto.getEmail());
        u.setStreet(userDto.getStreet());
        u.setHousenumber(userDto.getHousenumber());
        u.setZipcode(userDto.getZipcode());
        u.setCity(userDto.getCity());
//        u.setFavorites(userDto.getFavorites());
        u.setEnabled(userDto.getEnabled());
        u.setRole(userDto.getRole().toString());

        return this.repos.save(u);
    }

        @Override
        public UsersDto updateUsers(UsersDto usersDto, Long id) {
            Users use = repos.findById(id).orElseThrow(() -> new RecordNotFoundException("User not found"));
            use.setUsername(usersDto.getUsername());
            use.setPassword(usersDto.getPassword());
//            use.setPassword(encoder.encode(usersDto.getPassword()));
            use.setFirstname(usersDto.getFirstname());
            use.setLastname(usersDto.getLastname());
            use.setEmail(usersDto.getEmail());
            use.setStreet(usersDto.getStreet());
            use.setHousenumber(usersDto.getHousenumber());
            use.setZipcode(usersDto.getZipcode());
            use.setCity(usersDto.getCity());
//        use.setFavorites(usersDto.getFavorites());
            use.setEnabled(usersDto.getEnabled());
            use.setRole(usersDto.getRole().toString());
            repos.save(use);
            return mapper.map(use, UsersDto.class);
        }

        @Override
        public UsersDto deleteUsers(Long id) {
            Optional<Users> user = repos.findById(id);
            if(user.isPresent()){
                UsersDto userDto = mapper.map(user.get(), UsersDto.class);
                repos.deleteById(id);
                return userDto;
            } else {
                throw new RecordNotFoundException("Unable to find user");
            }
        }
}

