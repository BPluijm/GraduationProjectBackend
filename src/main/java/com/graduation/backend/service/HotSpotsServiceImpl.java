package com.graduation.backend.service;

import com.graduation.backend.dto.HotSpotsDto;
import com.graduation.backend.exceptions.RecordNotFoundException;
import com.graduation.backend.model.HotSpots;
import com.graduation.backend.repository.HotSpotsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import java.io.IOException;
import java.util.*;

@Service
public class HotSpotsServiceImpl  implements HotSpotsService {

    private final ModelMapper mapper = new ModelMapper();

    @Autowired
    HotSpotsRepository repos;

    @Override
    public List<HotSpotsDto> getHotSpots() {
        List<HotSpots> lh = this.repos.findAll();
        List<HotSpotsDto> spots = new ArrayList<>();
        for (HotSpots sp : lh) {
            HotSpotsDto hsd = mapper.map(sp, HotSpotsDto.class);
            spots.add(hsd);
        }
        return spots;
    }

    @Override
    public HotSpotsDto getHotSpotsById(Long id) {
        Optional<HotSpots> t = repos.findById(id);
        if (t.isPresent()) {
            HotSpots hotspots = t.get();
            return mapper.map(hotspots, HotSpotsDto.class);
        } else {
            throw new RecordNotFoundException("Trip not found");
        }
    }

//    @Override
//    public String addPdfToHotSpots(Long id, MultipartFile file) throws IOException {
//        return null;
//    }


    @Override
    public HotSpots createHotSpots(HotSpotsDto hsdt) throws IOException {
        HotSpots hs = new HotSpots();
        hs.setName(hsdt.getName());
        hs.setCountry(hsdt.getCountry());
        hs.setArea(hsdt.getArea());
        return this.repos.save(hs);

    }

    @Override
    public String updateHotSpots(HotSpotsDto hotSpots, Long id) throws IOException {
        HotSpots hots = repos.findById(id).orElseThrow(() -> new RecordNotFoundException("Hotspot not found"));
        hots.setName(hotSpots.getName());
        hots.setCountry(hotSpots.getCountry());
        hots.setArea(hotSpots.getArea());
        repos.save(hots);
        return "Hotspots are updated";
    }


    @Override
    public String deleteHotSpots(Long id) {
        repos.findById(id).orElseThrow(() -> new RecordNotFoundException("Hotspot not found"));
        repos.deleteById(id);
        return "Hotspot is deleted";

    }
}
