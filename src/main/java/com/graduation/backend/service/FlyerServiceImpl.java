package com.graduation.backend.service;

import com.graduation.backend.dto.FlyerDto;
import com.graduation.backend.exceptions.RecordNotFoundException;
import com.graduation.backend.model.Flyer;
import com.graduation.backend.model.HotSpots;
import com.graduation.backend.model.TravelTips;
import com.graduation.backend.repository.FlyerRepository;
import com.graduation.backend.repository.HotSpotsRepository;
import com.graduation.backend.repository.TravelTipsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.*;

@Service
public class FlyerServiceImpl implements FlyerService{

    private final ModelMapper mapper = new ModelMapper();

    @Autowired
    FlyerRepository repos;

    @Autowired
    HotSpotsRepository hRepo;

    @Autowired
    TravelTipsRepository tRepo;

    @Override
    public List<FlyerDto> getFlyer() {
        List<Flyer> ld = this.repos.findAll();
        List<FlyerDto> flyers = new ArrayList<>();
        for (Flyer flyer : ld) {
            FlyerDto flyerDto = mapper.map(flyer, FlyerDto.class);
            flyers.add(flyerDto);
        }
        return flyers;
    }

    @Override
    public byte[] getFlyerById(Long id) {
        Optional<Flyer> flyer = repos.findById(id);
        if (flyer.isPresent()) {
            return flyer.get().getFlyer();
        } else {
            throw new RecordNotFoundException("Flyer not found");
        }
    }

    @Override
    public Flyer createFlyer(MultipartFile file) throws IOException {
        Flyer newFlyer = new Flyer();
        newFlyer.setFlyer(file.getBytes());

//        HotSpots h = hRepo.getById(file.getHotSpots_id());
//        TravelTips t = tRepo.getById(file.getTravelTips_id());
//        newFlyer.setHotSpots(h);
//        newFlyer.setTravelTips(t);

        return this.repos.save(newFlyer);
    }

    @Override
    public String updateFlyer(MultipartFile file, Long id) throws IOException {
        Flyer flyer = repos.findById(id).orElseThrow(() -> new RecordNotFoundException("Flyer not found"));
        flyer.setFlyer(file.getBytes());
        repos.save(flyer);
        return "Flyer is updated";
    }

    @Override
    public String deleteFlyer(Long id) {
        Flyer flyer = repos.findById(id).orElseThrow(() -> new RecordNotFoundException("Flyer not found"));
        repos.deleteById(id);
        return "Flyer deleted";

    }
}
