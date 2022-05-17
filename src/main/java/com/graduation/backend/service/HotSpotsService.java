package com.graduation.backend.service;

import com.graduation.backend.dto.HotSpotsDto;
import com.graduation.backend.model.HotSpots;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface HotSpotsService {
    List<HotSpotsDto> getHotSpots();
    HotSpotsDto getHotSpotsById(Long id);
    HotSpots createHotSpots(HotSpotsDto hsdt) throws IOException;
    String updateHotSpots(HotSpotsDto hotSpots, Long id) throws IOException;
    String deleteHotSpots(Long id);
}
