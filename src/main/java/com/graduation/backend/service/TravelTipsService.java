package com.graduation.backend.service;

import com.graduation.backend.dto.TravelTipsDto;
import com.graduation.backend.model.TravelTips;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface TravelTipsService {
    List<TravelTipsDto> getTravelTips();
    byte[] getTravelTipsById(Long id);
    TravelTips createTravelTips(MultipartFile file) throws IOException;
    String updateTravelTips(MultipartFile file, Long id);
    String deleteTravelTips(Long id);

}
