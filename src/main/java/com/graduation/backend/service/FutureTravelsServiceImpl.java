package com.graduation.backend.service;

import com.graduation.backend.dto.FutureTravelsDto;
import com.graduation.backend.exceptions.RecordNotFoundException;
import com.graduation.backend.model.FutureTravels;
import com.graduation.backend.repository.FutureTravelsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FutureTravelsServiceImpl implements FutureTravelsService {

    @Autowired
    FutureTravelsRepository repos;

//    @Autowired
//    FutureTravelsService service;

    @Autowired
    private ModelMapper mapper;

//    private ModelMapper mapper = new ModelMapper();

    @Override
    public List<FutureTravelsDto> getFutureTravels() {
        List<FutureTravels> ld = repos.findAll();
        List<FutureTravelsDto> fut = new ArrayList<>();
        for (FutureTravels ft : ld) {
            FutureTravelsDto ftdto = mapper.map(ft, FutureTravelsDto.class);
            fut.add(ftdto);
        }

        return fut;
    }

    @Override
    public FutureTravelsDto getFutureTravelsById(Long id) {
        Optional<FutureTravels> fts = repos.findById(id);
        if (fts.isPresent()) {
            FutureTravels futs = fts.get();
            return mapper.map(futs, FutureTravelsDto.class);
        } else {
            throw new RecordNotFoundException("Future trip not found");
        }
    }

//    @Override
//    public FutureTravelsDto createFutureTravels(FutureTravelsDto fut) {
//        FutureTravels ftr = mapper.map(fut, FutureTravels.class);
//        FutureTravels ftrav = repos.save(ftr);
//        return mapper.map(ftrav, FutureTravelsDto.class);
//    }

    @Override
    public FutureTravels createFutureTravels(FutureTravelsDto fut) {
        FutureTravels ft = new FutureTravels();
        ft.setCountry(fut.getCountry());
        ft.setArea(fut.getArea());
        ft.setCategory(fut.getCategory());
        ft.setCategory(fut.getCategory());
        ft.setDuration(fut.getDuration());
        ft.setCosts(fut.getCosts());
        return this.repos.save(ft);
    }

//    @Override
//    public String addTips(Long tipId, TravelTipsDto ttdt, MultipartFile tips) {
//        FutureTravels futu = repos.findById(tipId).get();
//        TravelTips trt =  service.createTravelTips(ttdt, tips);
//        trt.setFutureTravels(futu);
//        futu.setTips(trt);
//        repos.save(futu);
//        return "Travel tips are added to the future trip";
//    }


//    @Override
//    public List<TravelTipsDto> getFutureTravelTips(Long id) {
//        Optional<FutureTravels> ftips = repos.findById(id);
//        List<TravelTipsDto> fttips = new ArrayList<>();
//        if(ftips.isPresent()) {
//            List<TravelTips> cars =  ftips.get().getFutureTravelTips();
//            for(TravelTips ttips : cars){
//                TravelTipsDto carDTO = mapper.map(ttips, TravelTipsDto.class);
//                fttips.add(carDTO);
//            }
//            return fttips;
//        } else {
//            throw new RecordNotFoundException("no car found");
//        }
//    }



    @Override
    public FutureTravelsDto updateFutureTravels(FutureTravelsDto ftd, Long id) {
        FutureTravels ft = repos.findById(id).orElseThrow(() -> new RecordNotFoundException("Future trip not found"));
        ft.setCountry(ftd.getCountry());
        ft.setArea(ftd.getArea());
        ft.setCategory(ftd.getCategory());
        ft.setDuration(ftd.getDuration());
        ft.setCosts(ftd.getCosts());
//        ft.setTips(ftd.getTips());
//        ft.getUsers(ftd.getUsers());
        repos.save(ft);
        return mapper.map(ft, FutureTravelsDto.class);
    }


    @Override
    public FutureTravelsDto deleteFutureTravels(Long id) {
        Optional<FutureTravels> ftr = repos.findById(id);
        if(ftr.isPresent()){
            FutureTravelsDto futured = mapper.map(ftr.get(), FutureTravelsDto.class);
            repos.deleteById(id);
            return futured;
        } else {
            throw new RecordNotFoundException("Unable to find future trip");
        }
    }
}
