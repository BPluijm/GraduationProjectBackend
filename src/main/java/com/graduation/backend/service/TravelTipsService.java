package com.graduation.backend.service;

import com.graduation.backend.dto.TravelTipsDto;
import com.graduation.backend.model.TravelTips;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface TravelTipsService {
    List<TravelTipsDto> getTravelTips();
//    byte[] getTravelTipsById(Long id);
    TravelTips createTravelTips(TravelTipsDto ttdt) throws IOException;
//    String addPdfToTravelTips(Long id, MultipartFile file) throws IOException;
    String updateTravelTips(TravelTipsDto ti, MultipartFile file, Long id) throws IOException;
    String deleteTravelTips(Long id);
}
