package com.graduation.backend.service;

import com.graduation.backend.dto.HotSpotsDto;
import com.graduation.backend.exceptions.RecordNotFoundException;
import com.graduation.backend.model.HotSpots;
import com.graduation.backend.repository.HotSpotsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HotSpotsServiceImpl  implements HotSpotsService {

    @Autowired
    HotSpotsRepository repos;

    @Autowired
    private ModelMapper mapper;

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
    public byte[] getHotSpotsById(Long id) {
        Optional<HotSpots> spots = repos.findById(id);
        if (spots.isPresent()) {
//            return spots.get().getHotSpots();
            return null;
        } else {
            throw new RecordNotFoundException("Hotspot not found");
        }
    }

    //    @Override
//    public String addPdfToHotSpots(Long id, MultipartFile file) throws IOException {
//        return null;
//    }


    @Override
    public HotSpots createHotSpots(HotSpotsDto hsdt, MultipartFile file) throws IOException {
        HotSpots hs = new HotSpots();
        hs.setName(hsdt.getName());
        hs.setCountry(hsdt.getCountry());
        hs.setArea(hsdt.getArea());
        hs.setFile(hsdt.getFile());
        return this.repos.save(hs);

    }

    @Override
    public String updateHotSpots(HotSpotsDto ti, MultipartFile file, Long id) throws IOException {
        HotSpots hots = repos.findById(id).orElseThrow(() -> new RecordNotFoundException("Hotspot not found"));
        hots.setName(ti.getName());
        hots.setCountry(ti.getCountry());
        hots.setArea(ti.getArea());
        hots.setFile(file.getBytes());
        repos.save(hots);
        return "Tips are updated";
    }


    @Override
    public String deleteHotSpots(Long id) {
        repos.findById(id).orElseThrow(() -> new RecordNotFoundException("Hotspot not found"));
        repos.deleteById(id);
        return "Hotspot is deleted";

    }
}
