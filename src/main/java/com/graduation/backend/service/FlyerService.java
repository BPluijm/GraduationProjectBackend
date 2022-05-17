package com.graduation.backend.service;

import com.graduation.backend.dto.FlyerDto;
import com.graduation.backend.model.Flyer;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FlyerService {
    List<FlyerDto> getFlyer();
    Flyer createFlyer(MultipartFile file) throws IOException;
    byte[] getFlyerById(Long id);
    String updateFlyer(MultipartFile file, Long id) throws IOException;
    String deleteFlyer(Long id);
}
