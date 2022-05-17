package com.graduation.backend.service;

import com.graduation.backend.model.Flyer;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FlyerService {
    Flyer createFlyer(MultipartFile file) throws IOException;
    byte[] getFlyerById(Long id);
    String updateFlyer(MultipartFile file, Long id) throws IOException;
    String deleteFlyer(Long id);
}
