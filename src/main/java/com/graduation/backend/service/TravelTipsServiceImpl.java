package com.graduation.backend.service;

import com.graduation.backend.dto.TravelTipsDto;
import com.graduation.backend.exceptions.RecordNotFoundException;
import com.graduation.backend.model.*;
import com.graduation.backend.repository.FutureTravelsRepository;
import com.graduation.backend.repository.TravelTipsRepository;
import com.graduation.backend.repository.UsersRepository;
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

    @Autowired
    UsersRepository uRepo;

    @Autowired
    FutureTravelsRepository ftRepo;

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

    @Override
    public TravelTips createTravelTips(TravelTipsDto ttdt) throws IOException {
        TravelTips tt = new TravelTips();
        tt.setName(ttdt.getName());
        tt.setCountry(ttdt.getCountry());
        tt.setCity(ttdt.getCity());
        tt.setDescription(ttdt.getDescription());

        FutureTravels ft = ftRepo.getById(ttdt.getFutureTravels_id());
        Users u = uRepo.getById(ttdt.getUsers_id());
        tt.setFutureTravels(ft);
        tt.setUsers(u);
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
