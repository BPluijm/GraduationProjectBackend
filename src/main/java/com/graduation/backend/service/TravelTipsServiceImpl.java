package com.graduation.backend.service;

import com.graduation.backend.dto.FavoritesDto;
import com.graduation.backend.dto.FutureTravelsDto;
import com.graduation.backend.dto.TravelTipsDto;
import com.graduation.backend.exceptions.RecordNotFoundException;
import com.graduation.backend.model.Favorites;
import com.graduation.backend.model.FutureTravels;
import com.graduation.backend.model.TravelTips;
import com.graduation.backend.model.Users;
import com.graduation.backend.repository.TravelTipsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.*;


@Service
public class TravelTipsServiceImpl implements TravelTipsService {

    private final ModelMapper mapper = new ModelMapper();

    @Autowired
    TravelTipsRepository repos;

    @Override
    public List<TravelTipsDto> getTravelTips() {
        List<TravelTips> ld = this.repos.findAll();
        List<TravelTipsDto> tips = new ArrayList<>();
        for (TravelTips tt : ld) {
            TravelTipsDto ttdto = mapper.map(tt, TravelTipsDto.class);
            tips.add(ttdto);
        }
        return tips;
    }

    @Override
    public TravelTipsDto getTravelTipsById(Long id) {
        Optional<TravelTips> t = repos.findById(id);
        if (t.isPresent()) {
            TravelTips travelTips = t.get();
            return mapper.map(travelTips, TravelTipsDto.class);
        } else {
            throw new RecordNotFoundException("Tip not found");
        }
    }


//
//    @Override
//    public List<FutureTravelsDto> getUsersTravelTips(Long id) {
//        Optional<TravelTips> travelTips = repos.findById(id);
//        List<FutureTravelsDto> futureTravels = new ArrayList<>();
//        if(travelTips.isPresent()) {
//            List<FutureTravels> future = (List<FutureTravels>) travelTips.get().getFutureTravels();
//            for(FutureTravels fut : future){
//                FutureTravelsDto futureTravelsDto = mapper.map(fut, FutureTravelsDto.class);
//                futureTravels.add(futureTravelsDto);
//            }
//            return futureTravels;
//        } else {
//            throw new RecordNotFoundException("No future travels found");
//        }
//    }




//    @Override
//    public String addPdfToTravelTips(Long id, MultipartFile file) throws IOException {
//        return null;
//    }

    @Override
    public TravelTips createTravelTips(TravelTipsDto ttdt) throws IOException {
        TravelTips tt = new TravelTips();
        tt.setName(ttdt.getName());
        tt.setCountry(ttdt.getCountry());
        tt.setCity(ttdt.getCity());
        tt.setDescription(ttdt.getDescription());
        return this.repos.save(tt);
    }

    @Override
    public String updateTravelTips(TravelTipsDto ti, Long id) throws IOException {
        TravelTips trt = repos.findById(id).orElseThrow(() -> new RecordNotFoundException("Tip not found"));
        trt.setName(ti.getName());
        trt.setCountry(ti.getCountry());
        trt.setCity(ti.getCity());
        trt.setDescription(ti.getDescription());
        repos.save(trt);
        return "Tips are updated";
    }

    @Override
    public String deleteTravelTips(Long id) {
        repos.findById(id).orElseThrow(() -> new RecordNotFoundException("Travel tip not found"));
        repos.deleteById(id);
        return "Travel tip is deleted";
    }
}
