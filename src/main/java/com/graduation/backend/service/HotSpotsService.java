package com.graduation.backend.service;

import com.graduation.backend.dto.HotSpotsDto;
import com.graduation.backend.model.HotSpots;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface HotSpotsService {
    List<HotSpotsDto> getHotSpots();
    byte[] getHotSpotsById(Long id);
    HotSpots createHotSpots(HotSpotsDto hsdt, MultipartFile file) throws IOException;
    String updateHotSpots(HotSpotsDto hot, MultipartFile file, Long id) throws IOException;
    String deleteHotSpots(Long id);
}
