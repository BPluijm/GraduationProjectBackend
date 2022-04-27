package com.graduation.backend.service;

import com.graduation.backend.dto.HotSpotsDto;
import com.graduation.backend.dto.TravelsDto;
import com.graduation.backend.exceptions.RecordNotFoundException;
import com.graduation.backend.model.HotSpots;
import com.graduation.backend.model.Travels;
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
            return spots.get().getHotSpots();
        } else {
            throw new RecordNotFoundException("Hot spot not found");
        }
    }


    @Override
    public byte[] createHotSpots(HotSpotsDto hsd, MultipartFile flyer) throws IOException{
        HotSpots hs = new HotSpots();
        hs.setHotSpots(flyer.getBytes());
        HotSpots hsp = repos.save(hs);

        return hsp;
    }

    @Override
    public String updateHotSpots(HotSpotsDto hs, MultipartFile flyer, Long id) throws IOException {
        HotSpots hot = repos.findById(id).orElseThrow(() -> new RecordNotFoundException("Hot spot not found"));
        hot.setHotSpots(flyer.getBytes());
        repos.save(hot);
        return "Hot spots are updated";
    }

    // DELETE
    @Override
    public String deleteHotSpot(Long id) {
        HotSpots spots = repos.findById(id).orElseThrow(() -> new RecordNotFoundException("Hot spot not found"));
        repos.deleteById(id);
        return "Hot spot deleted";

    }
}
