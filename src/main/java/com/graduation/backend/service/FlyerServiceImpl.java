package com.graduation.backend.service;

import com.graduation.backend.exceptions.RecordNotFoundException;
import com.graduation.backend.model.Flyer;
import com.graduation.backend.repository.FlyerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class FlyerServiceImpl implements FlyerService{
    @Autowired
    FlyerRepository repos;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Flyer createFlyer(MultipartFile file) throws IOException {
        Flyer newFlyer = new Flyer();
        newFlyer.setFlyer(file.getBytes());
        Flyer flyer = repos.save(newFlyer);

        return flyer;
    }

    @Override
    public byte[] getFlyerById(Long id) {
        Optional<Flyer> flyer = repos.findById(id);
        if (flyer.isPresent()) {
            return flyer.get().getFlyer();
        } else {
            throw new RecordNotFoundException("Flyer not found");
        }
    }

    @Override
    public String updateFlyer(MultipartFile file, Long id) throws IOException {
        Flyer flyer = repos.findById(id).orElseThrow(() -> new RecordNotFoundException("Flyer not found"));
        flyer.setFlyer(file.getBytes());
        repos.save(flyer);
        return "Flyer is updated";
    }

    @Override
    public String deleteFlyer(Long id) {
        Flyer flyer = repos.findById(id).orElseThrow(() -> new RecordNotFoundException("Flyer not found"));
        repos.deleteById(id);
        return "Flyer deleted";

    }
}
