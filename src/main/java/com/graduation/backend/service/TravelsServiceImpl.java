package com.graduation.backend.service;

import com.graduation.backend.dto.TravelsDto;
//import com.graduation.backend.dto.UsersDto;
//import com.graduation.backend.exceptions.RecordNotFoundException;
import com.graduation.backend.model.Travels;
//import com.graduation.backend.model.Users;
import com.graduation.backend.repository.TravelsRepository;
//import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
//import java.util.Optional;

@Service
public class TravelsServiceImpl implements TravelsService {

    private final TravelsRepository repos;

    public TravelsServiceImpl(TravelsRepository repos) {
        this.repos = repos;
    }

    @Override
    public List<TravelsDto> getTravels() {
        List<Travels> ld = this.repos.findAll();
        List<TravelsDto> travels = new ArrayList<>();

        for (Travels tr : ld) {
            TravelsDto trdto = new TravelsDto(tr.getId(), tr.getCountry(), tr.getStartYear(), tr.getCity(), tr.getTravelType(), tr.getDescription(), tr.getTravelTime());
            travels.add(trdto);
        }

        return travels;
    }

   @Override
    public Travels createTravels(TravelsDto travelsDto) {
        Travels tr = new Travels();
        tr.setCountry(travelsDto.getCountry());
        tr.setStartYear(travelsDto.getStartYear());
        tr.setCity(travelsDto.getCity());
        tr.setTravelType(travelsDto.getTravelType());
        tr.setDescription(travelsDto.getDescription());
        tr.setTravelTime(travelsDto.getTravelTime());
        return this.repos.save(tr);
    }
//
//    @Override
//    public UsersDto findTravelsById(Long id) {
//        Optional<Travels> travels =  repos.findById(id);
//        if (travels.isPresent()){
//            UsersDto uDto = modelMapper.map(travels.get(), UsersDto.class);
//            return uDto;
//
//        } else {
//            throw new RecordNotFoundException("Trip not found");
//        }
//    }
//
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
//    @Override
//    public UsersDto updateTravels(@NotNull TravelsDto travelsDto, Long id) {
//        Travels trip = repos.findById(id).orElseThrow(() -> new RecordNotFoundException("user not found"));
//        trip.setFirstname(travelsDto.getFirstname());
//        trip.setLastname(travelsDto.getLastname());
//        trip.setStreet(travelsDto.getStreet());
//        trip.setZipcode(travelsDto.getZipcode());
//        trip.setEmail(travelsDto.getEmail());
//        trip.setHouseNumber(travelsDto.getHouseNumber());
//        trip.setCity(travelsDto.getCity());
//        trip.setFavorites(travelsDto.getFavorites());
//        usersRepository.save(users);
//        return modelMapper.map(users, UsersDto.class);
//    }
//
//    @Override
//    public UsersDto deleteUsers(Long id) {
//        Optional<Users> users = repos.findById(id);
//        if(users.isPresent()){
//            if(users.get().getFavorites() != null){
//                for (Favorites favorites : users.get().getFavorites()){
//                    Long usersId = users.getId();
//                    repos.deleteById(usersId);
//                }
//            }
//            UsersDto usersDto = modelMapper.map(users.get(), UsersDto.class);
//            usersRepository.deleteById(id);
//            return usersDto;
//        } else {
//            throw new RecordNotFoundException("unable to find customer");
//        }
//
//    }
}
