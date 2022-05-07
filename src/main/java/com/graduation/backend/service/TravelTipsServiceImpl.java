package com.graduation.backend.service;

import com.graduation.backend.dto.TravelTipsDto;
import com.graduation.backend.exceptions.RecordNotFoundException;
import com.graduation.backend.model.TravelTips;
import com.graduation.backend.repository.TravelTipsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;


@Service
public class TravelTipsServiceImpl implements TravelTipsService {

    @Autowired
    TravelTipsRepository repos;

    @Autowired
    private ModelMapper mapper;



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
    public byte[] getTravelTipsById(Long id) {
        Optional<TravelTips> trtip = repos.findById(id);
        if (trtip.isPresent()) {
//            return trtip.get().getFolder();
            return null;
        } else {
            throw new RecordNotFoundException("Travel tip not found");
        }
    }

//    @Override
//    public String addPdfToTravelTips(Long id, MultipartFile file) throws IOException {
//        return null;
//    }

    @Override
    public TravelTips createTravelTips(TravelTipsDto ttdt, MultipartFile file) throws IOException {
        TravelTips tt = new TravelTips();
        tt.setName(ttdt.getName());
        tt.setCountry(ttdt.getCountry());
        tt.setCity(ttdt.getCity());
        tt.setDescription(ttdt.getDescription());
        tt.setFile(ttdt.getFile());
        return this.repos.save(tt);

    }

    @Override
    public String updateTravelTips(TravelTipsDto ti, MultipartFile file, Long id) throws IOException {
        TravelTips trt = repos.findById(id).orElseThrow(() -> new RecordNotFoundException("Tip not found"));
        trt.setName(ti.getName());
        trt.setCountry(ti.getCountry());
        trt.setCity(ti.getCity());
        trt.setDescription(ti.getDescription());
//        trt.setFolder(file.getBytes());
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
